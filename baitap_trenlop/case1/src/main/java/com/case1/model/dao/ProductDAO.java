package com.case1.model.dao;

import com.case1.connection.JdbcConnection;
import com.case1.model.entity.Product;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {

    private static final String FILTER_PRODUCT = "select * from products where type = ?;";
    private static final String GET_TYPE = "select distinct type from products;";
    private static final String INSERT_PRODUCT = "insert into products (name, price, quantity, type, country) values(?,?,?,?,?);";
    private static final String SELECT_PRODUCT_BY_ID = "select * from products where id = ?;";
    private static final String SELECT_ALL_PRODUCT = "select * from product;";
    private static final String DELETE_PRODUCT = "delete from products where id = ?;";
    private static final String UPDATE_PRODUCT = "update products set name = ?, price = ?, quantity = ?, type = ?, country = ?" + " where id = ?;";
    private static final String SEARCH_PRODUCT = "select id, name, price, quantity, type, country from products where name like ? order by id desc limit 6 offset?;";

    public ProductDAO() {
    }

    @Override
    public void insertProduct(Product product) throws SQLException {
        System.out.println(INSERT_PRODUCT);
        try (Connection connection = JdbcConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT)) {

            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setDouble(2, product.getProductPrice());
            preparedStatement.setInt(3, product.getProductQuantity());
            preparedStatement.setString(4, product.getProductType());
            preparedStatement.setString(5, product.getCountry());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product getProduct(int id) throws SQLException {
        Product product = null;
        try (Connection connection = JdbcConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int productID = resultSet.getInt("id");
                    String productName = resultSet.getString("name");
                    double productPrice = resultSet.getDouble("price");
                    int productQuantity = resultSet.getInt("quantity");
                    String productType = resultSet.getString("type");
                    String country = resultSet.getString("country");

                    product = new Product(productID, productName, productPrice, productQuantity, productType, country);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> getAllProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        request.setAttribute("searchQuery", "");
        List<Product> productList = searchProduct(request, response);
        return productList;
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
            try (Connection connection = JdbcConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT)) {
                 {
                    preparedStatement.setString(1, product.getProductName());
                    preparedStatement.setDouble(2, product.getProductPrice());
                    preparedStatement.setInt(3, product.getProductQuantity());
                    preparedStatement.setString(4, product.getProductType());
                    preparedStatement.setString(5, product.getCountry());
                    preparedStatement.setInt(6, product.getProductID());
                }
            }
    }

    public static void countProduct(HttpServletRequest request, String searchQuery) {
        try (Connection connection = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select count(*) from product where name like ?")) {
            searchQuery = "%" + searchQuery + "%";
            preparedStatement.setString(1, searchQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            int total = 1;
            int endPage;
            while (resultSet.next()) {
                total = resultSet.getInt(1);
            }
            if ((total % 6) != 0) {
                endPage = (total / 6) + 1;
            } else {
                endPage = total / 6;
            }
            request.setAttribute("endPage", endPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> searchProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<Product> productList = new ArrayList<>();
        String searchQuery = (String) request.getAttribute("searchQuery");
        searchQuery = "%" + searchQuery + "%";
        countProduct(request, searchQuery);

        try (Connection connection = JdbcConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_PRODUCT)) {

            preparedStatement.setString(1, searchQuery);
            int page = 1;
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            preparedStatement.setInt(2, (page -1) * 6);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                int productID = resultSet.getInt("id");
                String productName = resultSet.getString("name");
                double productPrice = resultSet.getDouble("Price");
                int quantity = resultSet.getInt("quantity");
                String type = resultSet.getString("type");
                String country = resultSet.getString("country");

                productList.add(new Product(productID, productName, productPrice, quantity, type, country));
            }
        }
        return productList;
    }

    @Override
    public void deleteProduct(int productID) throws SQLException {
        Connection connection = JdbcConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT);
        preparedStatement.setInt(1, productID);
        preparedStatement.executeUpdate();
    }

    @Override
    public List<Product> filter(String filterType) throws SQLException, NullPointerException {
        List<Product> productList = new ArrayList<>();
        Connection connection = JdbcConnection.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(FILTER_PRODUCT);
        preparedStatement.setString(1, filterType);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            int productID = resultSet.getInt("id");
            String productName = resultSet.getString("name");
            double price = resultSet.getDouble("price");
            int quantity = resultSet.getInt("quantity");
            String type = resultSet.getString("type");
            String country = resultSet.getString("country");

            productList.add(new Product(productID, productName, price, quantity, type, country));
        }
        return productList;
    }

    @Override
    public List<String> getTypeList() throws SQLException {
        List<String> typeList = new ArrayList<>();
        Connection connection = JdbcConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_TYPE);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String type = resultSet.getString("type");
            typeList.add(type);
        }
        return typeList;
    }
}
