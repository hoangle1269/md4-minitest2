package com.example.md4minitest2computer.repository;

import com.example.md4minitest2computer.model.Computer;
import com.example.md4minitest2computer.model.Manufacturer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComputerRepository extends JpaRepository<Computer,Long> {
    Iterable<Computer> findAllByManufacturer(Manufacturer manufacturer);

    Page<Computer> findAll(Pageable pageable);

    Page<Computer> findAllByNameContaining(Pageable pageable, String computerName);

//    dinh nghia phuong thuc truy van
//    tim kiem theo lastName
//    danh sach
//    Phai viet dung theo goi y
//    Page<Customer> findAllByLastNameContaining(Pageable pageable, String name);
}

