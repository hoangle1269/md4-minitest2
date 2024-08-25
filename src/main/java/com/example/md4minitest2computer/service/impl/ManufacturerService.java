package com.example.md4minitest2computer.service.impl;

import com.example.md4minitest2computer.model.DTO.ICountManufacturer;
import com.example.md4minitest2computer.model.Manufacturer;
import com.example.md4minitest2computer.repository.IManufacturerRepository;
import com.example.md4minitest2computer.service.IManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManufacturerService implements IManufacturerService {

    @Autowired

    private IManufacturerRepository iManufacturerRepository;

    @Override
    public Iterable<Manufacturer> findAll() {
        return iManufacturerRepository.findAll();
    }

    @Override
    public void save(Manufacturer manufacturer) {
        iManufacturerRepository.save(manufacturer);
    }

    @Override
    public Optional<Manufacturer> findById(Long id) {
        return iManufacturerRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iManufacturerRepository.deleteById(id);
    }

    @Override
    public void deleteManufacturerById(Long id) {
        iManufacturerRepository.deleteManufacturerById(id);
    }

    @Override
    public Iterable<ICountManufacturer> getNumbersOfManufacturer() {
        return iManufacturerRepository.getNumbersOfManufacturer();
    }


}