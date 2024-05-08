package com.case_2.dto;

public class ProducerWithProductsDTO {
    private int id;
    private String producerName;
    private String producerAddress;
    private String producerCountry;
    private String productName;
    private double price;

    public ProducerWithProductsDTO() {
    }

    public ProducerWithProductsDTO(String producerName, String producerAddress, String producerCountry, String productName, double price) {
        this.producerName = producerName;
        this.producerAddress = producerAddress;
        this.producerCountry = producerCountry;
        this.productName = productName;
        this.price = price;
    }

    public ProducerWithProductsDTO(int id, String producerName, String producerAddress, String producerCountry, String productName, double price) {
        this.id = id;
        this.producerName = producerName;
        this.producerAddress = producerAddress;
        this.producerCountry = producerCountry;
        this.productName = productName;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getProducerAddress() {
        return producerAddress;
    }

    public void setProducerAddress(String producerAddress) {
        this.producerAddress = producerAddress;
    }

    public String getProducerCountry() {
        return producerCountry;
    }

    public void setProducerCountry(String producerCountry) {
        this.producerCountry = producerCountry;
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
}
