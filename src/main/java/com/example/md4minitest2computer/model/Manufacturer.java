package com.example.md4minitest2computer.model;

import javax.persistence.*;

@Entity
@Table(name = "manufacturer")
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long manufacturerId;
    private String manufacturerName;

    public Manufacturer() {
    }

    public Manufacturer(Long manufacturerId, String manufacturerName) {
        this.manufacturerId = manufacturerId;
        this.manufacturerName = manufacturerName;
    }

    public Long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }
}
