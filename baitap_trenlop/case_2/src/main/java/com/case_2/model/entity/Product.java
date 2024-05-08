package com.case_2.model.entity;

public class Product {
    private int id;
    private String name;
    private double price;
    private String producer;
    private String categories;
    private String shipper;
    private String image;

    public Product() {
    }

    public Product(String name, double price, String producer, String categories, String shipper, String image) {
        this.name = name;
        this.price = price;
        this.producer = producer;
        this.categories = categories;
        this.shipper = shipper;
        this.image = image;
    }

    public Product(int id, String name, double price, String producer, String categories, String shipper, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.producer = producer;
        this.categories = categories;
        this.shipper = shipper;
        this.image = image;
    }

//    public Product(String productName, double price, String producerName, String producerAddress, String producerCountry) {
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getShipper() {
        return shipper;
    }

    public void setShipper(String shipper) {
        this.shipper = shipper;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
