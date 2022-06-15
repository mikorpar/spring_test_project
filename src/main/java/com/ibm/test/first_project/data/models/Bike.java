package com.ibm.test.first_project.data.models;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Bike {
    private int id;
    private String name;
    private String brand;
    private BigDecimal price;
    private String color;
}
