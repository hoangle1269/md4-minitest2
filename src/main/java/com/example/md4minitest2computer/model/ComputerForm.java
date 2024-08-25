package com.example.md4minitest2computer.model;

import org.springframework.web.multipart.MultipartFile;

public class ComputerForm {
    private Long computerId;
    private String computerCode;
    private String computerName;
    private double price;
    private String description;
    private MultipartFile img;
    private Manufacturer manufacturerId; // Sử dụng ID của Manufacturer để giữ khóa ngoại

    public ComputerForm() {
    }

    public ComputerForm(Long computerId, String computerCode, String computerName, double price, String description, MultipartFile img, Manufacturer manufacturerId) {
        this.computerId = computerId;
        this.computerCode = computerCode;
        this.computerName = computerName;
        this.price = price;
        this.description = description;
        this.img = img;
        this.manufacturerId = manufacturerId;
    }

    public Long getComputerId() {
        return computerId;
    }

    public void setComputerId(Long computerId) {
        this.computerId = computerId;
    }

    public String getComputerCode() {
        return computerCode;
    }

    public void setComputerCode(String computerCode) {
        this.computerCode = computerCode;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }

    public Manufacturer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Manufacturer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

}
