package com.case_2.model.dao;

import com.case_2.Connection.JdbcConnection;
import com.case_2.dto.ProducerWithProductsDTO;
import com.case_2.model.entity.Product;
import com.case_2.dto.ProductWithCategoryAndShipperDTO;
import com.case_2.dto.ProductWithProducersDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    private static final String SELECT_PRODUCTS_BY_ID = "select * from products where id = ?";
    private static final String SELECT_ALL_PRODUCTS = "select * from products";
    private static final String INSERT_PRODUCT = "insert into products (name, price, producer, categories, shipper, image) values (?,?,?,?,?,?)";
    private static final String UPDATE_PRODUCT = "update products set name = ?, price = ?, producer = ?, categories = ?, shipper = ?, image = ? where id = ?";
    private static final String DELETE_PRODUCT = "delete from products where id = ?";
    private static final String SORTED_PRODUCTS_DESCENDING = "select * from products order by price desc";
    private static final String SORTED_PRODUCTS_ASCENDING = "select * from products order by price asc";

    @Override
    public Product getProductById(int id) {
        Product product = null;
        try(Connection connection = JdbcConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCTS_BY_ID)) {

                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()){
                    product = new Product(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getDouble("price"),
                            resultSet.getString("producer"),
                            resultSet.getString("categories"),
                            resultSet.getString("shipper"),
                            resultSet.getString("image")
                    );
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try(Connection connection = JdbcConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Product product = new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getString("producer"),
                        resultSet.getString("categories"),
                        resultSet.getString("shipper"),
                        resultSet.getString("image")
                );
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public List<ProductWithProducersDTO> getProductsWithProducers() {
        List<ProductWithProducersDTO> products = new ArrayList<>();

        try (Connection connection = JdbcConnection.getConnection(); CallableStatement callableStatement = connection.prepareCall("call GetProductsWithProducers()"); ResultSet resultSet = callableStatement.executeQuery()) {

            while (resultSet.next()) {
                ProductWithProducersDTO product = new ProductWithProducersDTO(
//                        resultSet.getInt("id"),
                        resultSet.getString("Product Name"),
                        resultSet.getDouble("Price"),
                        resultSet.getString("Producer Name"),
                        resultSet.getString("Producer Address"),
                        resultSet.getString("Producer Country")
                        //null - Không có thông tin về ảnh
                );
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public List<ProducerWithProductsDTO> getProducersWithProducts() {
        List<ProducerWithProductsDTO> products = new ArrayList<>();

        try(Connection connection = JdbcConnection.getConnection(); CallableStatement callableStatement = connection.prepareCall("call GetProducersWithProducts()"); ResultSet resultSet = callableStatement.executeQuery()) {

            while (resultSet.next()) {
                ProducerWithProductsDTO product = new ProducerWithProductsDTO(
                        resultSet.getString("Producer Name"),
                        resultSet.getString("Producer Address"),
                        resultSet.getString("Producer Country"),
                        resultSet.getString("Product Name"),
                        resultSet.getDouble("Price")
                );
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public List<ProductWithCategoryAndShipperDTO> getProductsWithCategoriesAndShippers() {
        List<ProductWithCategoryAndShipperDTO> products = new ArrayList<>();

        try(Connection connection = JdbcConnection.getConnection(); CallableStatement callableStatement = connection.prepareCall("call GetProductsWithCategoriesAndShippers()"); ResultSet resultSet = callableStatement.executeQuery()) {

            while (resultSet.next()){
                ProductWithCategoryAndShipperDTO product = new ProductWithCategoryAndShipperDTO(
                        resultSet.getString("Product Name"),
                        resultSet.getDouble("Price"),
                        resultSet.getString("Category Name"),
                        resultSet.getString("Category Description"),
                        resultSet.getString("Shipper Name"),
                        resultSet.getInt("Shipper Age")
                );
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public List<Product> sortProductsByPriceAscending() {
        List<Product> sortedProductList = new ArrayList<>();
        try(Connection connection = JdbcConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SORTED_PRODUCTS_ASCENDING)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Product product = new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getString("producer"),
                        resultSet.getString("categories"),
                        resultSet.getString("shipper"),
                        resultSet.getString("image")
                );
                sortedProductList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sortedProductList;
    }

    public List<Product> sortProductsByPriceDescending() {
        List<Product> sortedProductList = new ArrayList<>();
        try(Connection connection = JdbcConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SORTED_PRODUCTS_DESCENDING)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Product product = new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getString("producer"),
                        resultSet.getString("categories"),
                        resultSet.getString("shipper"),
                        resultSet.getString("image")
                );
                sortedProductList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sortedProductList;
    }

    @Override
    public void createProduct(Product product) {
        try (Connection connection = JdbcConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getProducer());
            preparedStatement.setString(4, product.getCategories());
            preparedStatement.setString(5, product.getShipper());
            preparedStatement.setString(6, product.getImage());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean updateProduct(Product product) {
        try(Connection connection = JdbcConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getProducer());
            preparedStatement.setString(4, product.getCategories());
            preparedStatement.setString(5, product.getShipper());
            preparedStatement.setString(6, product.getImage());
            preparedStatement.setInt(7, product.getId());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteProduct(int productId) {
        try(Connection connection = JdbcConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT)) {
            preparedStatement.setInt(1, productId);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
