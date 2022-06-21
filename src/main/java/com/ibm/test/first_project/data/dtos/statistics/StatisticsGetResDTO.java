package com.ibm.test.first_project.data.dtos.statistics;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StatisticsGetResDTO {
    private BigDecimal totalIncome;
    private Double percentage;
}
