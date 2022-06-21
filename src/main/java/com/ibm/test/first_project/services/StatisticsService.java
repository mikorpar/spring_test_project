package com.ibm.test.first_project.services;

import com.ibm.test.first_project.data.dtos.Statistics;

public interface StatisticsService {

    Statistics calcTotalSalesIncomeByBrand(String brand);

    Statistics calcTotalSalesIncomeByColor(String color);

    Statistics calcTotalSalesIncomeByBrandAndColor(String brand, String color);
}
