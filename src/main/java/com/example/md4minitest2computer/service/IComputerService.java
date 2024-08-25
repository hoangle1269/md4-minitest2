package com.example.md4minitest2computer.service;

import com.example.md4minitest2computer.model.Computer;
import com.example.md4minitest2computer.model.Manufacturer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IComputerService extends IGenerateService<Computer>{
    Iterable<Computer> findAllByManufacturer(Manufacturer manufacturer);

    Page<Computer> findAll(Pageable pageable);

    Page<Computer> findAllByNameContaining(Pageable pageable, String name);
}