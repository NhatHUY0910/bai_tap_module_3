package com.case_2.dto;

public class ProductWithProducersDTO {
    private int id;
    private String name;
    private double price;
    private String producerName;
    private String producerAddress;
    private String producerCountry;

    public ProductWithProducersDTO() {
    }

    public ProductWithProducersDTO(String name, double price, String producerName, String producerAddress, String producerCountry) {
        this.name = name;
        this.price = price;
        this.producerName = producerName;
        this.producerAddress = producerAddress;
        this.producerCountry = producerCountry;
    }

    public ProductWithProducersDTO(int id, String name, double price, String producerName, String producerAddress, String producerCountry) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.producerName = producerName;
        this.producerAddress = producerAddress;
        this.producerCountry = producerCountry;
    }

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
}
