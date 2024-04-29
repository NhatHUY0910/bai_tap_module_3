package com.case1.model.entity;

public interface IProductService {
    void addProduct(Product product);
    void showAllProducts();
    void updateProduct(Product product);
    void deleteProduct(Product product);
}
