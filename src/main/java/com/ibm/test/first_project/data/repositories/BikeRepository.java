package com.ibm.test.first_project.data.repositories;

import com.ibm.test.first_project.data.models.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BikeRepository extends JpaRepository<Bike,Long> {
    List<Bike> findAll();
    List<Bike> findAllByBrand(String brand);
}
