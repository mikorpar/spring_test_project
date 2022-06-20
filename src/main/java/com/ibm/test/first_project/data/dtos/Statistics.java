package com.ibm.test.first_project.data.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Statistics {
    private BigDecimal totalIncome;
    private Double percentage;
}
