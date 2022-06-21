package com.ibm.test.first_project.data.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BikeUpdateReqDTO {
    private String name;
    private String brand;
    private BigDecimal price;
    private String color;
}