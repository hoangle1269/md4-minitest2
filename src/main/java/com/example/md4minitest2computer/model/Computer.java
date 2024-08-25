package com.example.md4minitest2computer.model;

import javax.persistence.*;


@Entity
@Table (name = "computer")
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//danh dau tt tu tang
    private Long computerId;
    private String computerCode;
    private String computerName;

    private double price;
    private String description;
    private String img;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    public Computer() {
    }

    public Computer(Long computerId, String computerCode, String computerName, double price, String description, String img, Manufacturer manufacturer) {
        this.computerId = computerId;
        this.computerCode = computerCode;
        this.computerName = computerName;
        this.price = price;
        this.description = description;
        this.img = img;
        this.manufacturer = manufacturer;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
