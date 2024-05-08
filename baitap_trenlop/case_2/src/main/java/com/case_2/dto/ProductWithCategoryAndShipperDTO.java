package com.case_2.dto;

public class ProductWithCategoryAndShipperDTO {
    private int id;
    private String productName;
    private double price;
    private String categoryName;
    private String categoryDescription;
    private String shipperName;
    private int shipperAge;

    public ProductWithCategoryAndShipperDTO() {
    }

    public ProductWithCategoryAndShipperDTO(String productName, double price, String categoryName, String categoryDescription, String shipperName, int shipperAge) {
        this.productName = productName;
        this.price = price;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.shipperName = shipperName;
        this.shipperAge = shipperAge;
    }

    public ProductWithCategoryAndShipperDTO(int id, String productName, double price, String categoryName, String categoryDescription, String shipperName, int shipperAge) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.shipperName = shipperName;
        this.shipperAge = shipperAge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public int getShipperAge() {
        return shipperAge;
    }

    public void setShipperAge(int shipperAge) {
        this.shipperAge = shipperAge;
    }
}
