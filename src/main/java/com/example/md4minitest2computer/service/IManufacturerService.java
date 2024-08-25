package com.example.md4minitest2computer.service;

import com.example.md4minitest2computer.model.DTO.ICountManufacturer;
import com.example.md4minitest2computer.model.Manufacturer;

public interface IManufacturerService extends IGenerateService<Manufacturer> {

    void deleteManufacturerById(Long id);

    Iterable<ICountManufacturer> getNumbersOfManufacturer();
}
