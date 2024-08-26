package com.example.md4minitest2computer.repository;

import com.example.md4minitest2computer.model.DTO.ICountManufacturer;
import com.example.md4minitest2computer.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IManufacturerRepository extends JpaRepository<Manufacturer,Long> {
    //anno de sua du lieu
    @Modifying
    //anno de thuc hien nhieu thao tac
    @Transactional
    @Query(value = "CALL deletemanufacturerbyid(:id)", nativeQuery = true)
    void deleteManufacturerById(@Param("id")Long manufacturerId);

    @Query(nativeQuery = true, value = "CALL countNumbersOfManufacturer()")
    Iterable<ICountManufacturer> getNumbersOfManufacturer();
}
