package com.case1.model.dao;

import com.case1.model.entity.Product;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    public void insertProduct(Product product) throws SQLException;

    Product getProduct(int id) throws SQLException;

    public List<Product> getAllProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException;

    public void updateProduct(Product product) throws SQLException;

    public List<Product> searchProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException;

    public void deleteProduct(int productID) throws SQLException;

    public List<Product> filter(String action) throws SQLException;

    List<String> getTypeList() throws SQLException;

}
