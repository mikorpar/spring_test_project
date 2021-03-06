package com.ibm.test.first_project.data.dtos.bike;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BikeUpdateResDTO {
    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private String color;
}
