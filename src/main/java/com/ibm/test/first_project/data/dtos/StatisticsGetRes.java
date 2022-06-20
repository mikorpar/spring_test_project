package com.ibm.test.first_project.data.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StatisticsGetRes {
    private BigDecimal totalIncome;
    private Double percentage;
}
