package com.ibm.test.first_project.data.repositories;

import com.ibm.test.first_project.data.models.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, Long> {
    Color findByName(String name);
}
