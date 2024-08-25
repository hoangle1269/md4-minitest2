package com.example.md4minitest2computer.service.impl;

import com.example.md4minitest2computer.model.Computer;
import com.example.md4minitest2computer.model.Manufacturer;
import com.example.md4minitest2computer.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComputerService implements IComputerService {

    @Autowired
    private IComputerService iComputerService;


    @Override
    public Iterable<Computer> findAll() {
        return iComputerService.findAll();
    }

    @Override
    public void save(Computer computer) {
        iComputerService.save(computer);
    }

    @Override
    public Optional<Computer> findById(Long computerId) {
        return iComputerService.findById(computerId);
    }

    @Override
    public void remove(Long computerId) {
        iComputerService.remove(computerId);
    }

    @Override
    public Iterable<Computer> findAllByManufacturer(Manufacturer manufacturer) {
        return iComputerService.findAllByManufacturer(manufacturer);
    }

    @Override
    public Page<Computer> findAll(Pageable pageable) {
        return iComputerService.findAll(pageable);
    }

    @Override
    public Page<Computer> findAllByNameContaining(Pageable pageable, String name) {
        return iComputerService.findAllByNameContaining(pageable,name);
    }
}
