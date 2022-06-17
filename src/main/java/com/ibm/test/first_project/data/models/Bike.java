package com.ibm.test.first_project.data.models;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Table
@Entity
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private String color;
}
