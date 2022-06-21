package com.ibm.test.first_project.data.repositories;

import com.ibm.test.first_project.data.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    Brand findByName(String name);
}
