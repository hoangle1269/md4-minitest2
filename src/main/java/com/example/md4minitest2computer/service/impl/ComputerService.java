package com.example.md4minitest2computer.service.impl;

import com.example.md4minitest2computer.model.Computer;
import com.example.md4minitest2computer.model.Manufacturer;
import com.example.md4minitest2computer.repository.IComputerRepository;
import com.example.md4minitest2computer.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComputerService implements IComputerService {

    @Autowired
    private IComputerRepository iComputerRepository;


    @Override
    public Iterable<Computer> findAll() {
        return iComputerRepository.findAll();
    }

    @Override
    public void save(Computer computer) {
        iComputerRepository.save(computer);
    }

    @Override
    public Optional<Computer> findById(Long computerId) {
        return iComputerRepository.findById(computerId);
    }

    @Override
    public void remove(Long computerId) {
        iComputerRepository.deleteById(computerId);
    }

    @Override
    public Iterable<Computer> findAllByManufacturer(Manufacturer manufacturer) {
        return iComputerRepository.findAllByManufacturer(manufacturer);
    }

    @Override
    public Page<Computer> findAll(Pageable pageable) {
        return iComputerRepository.findAll(pageable);
    }

    @Override
    public Page<Computer> findAllByNameContaining(Pageable pageable, String computerName) {
        return iComputerRepository.findAllByComputerNameContaining(pageable,computerName);
    }
}
