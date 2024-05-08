package com.case_2.model.dao;

import com.case_2.model.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    public Product getProductById(int id) throws SQLException;
    public List<Product> getAllProducts() throws SQLException;
    public void createProduct(Product product) throws SQLException;
    public boolean updateProduct(Product product) throws SQLException;
    public boolean deleteProduct(int productId) throws SQLException;
}
