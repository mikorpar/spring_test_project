package com.ibm.test.first_project.services.impl;

import com.ibm.test.first_project.data.dtos.Statistics;
import com.ibm.test.first_project.data.models.Bike;
import com.ibm.test.first_project.data.models.OrderItem;
import com.ibm.test.first_project.data.models.SalesOrder;
import com.ibm.test.first_project.services.BikeService;
import com.ibm.test.first_project.services.SalesOrderService;
import com.ibm.test.first_project.services.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {

    private final SalesOrderService salesOrderService;
    private final BikeService bikeService;

    @Override
    public Statistics calcTotalSalesIncomeByBrand(String brand) {
        return calcTotalSalesIncomeByBikeProperty(bikeService.getAllBikesByBrandOrderedThisYear(brand));
    }

    @Override
    public Statistics calcTotalSalesIncomeByColor(String color) {
        return calcTotalSalesIncomeByBikeProperty(bikeService.getAllBikesByColorOrderedThisYear(color));
    }

    @Override
    public Statistics calcTotalSalesIncomeByBrandAndColor(String brand, String color) {
        return calcTotalSalesIncomeByBikeProperty(bikeService.getAllBikesByBrandAndColorOrderedThisYear(brand, color));
    }

    private Statistics calcTotalSalesIncomeByBikeProperty(List<Bike> bikes) {
        BigDecimal totalIncome = calcTotalSalesIncome();
        BigDecimal totalIncomeByBrand = BigDecimal.valueOf(0);

        for (Bike bike : bikes) {
            for (OrderItem item : bike.getItems()) {
                totalIncomeByBrand = totalIncomeByBrand.add(item.getBike().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
            }
        }

        Statistics stastistics = new Statistics();
        stastistics.setTotalIncome(totalIncome);
        stastistics.setPercentage(totalIncomeByBrand.divide(totalIncome, 2, RoundingMode.HALF_UP).doubleValue() * 100);

        return stastistics;
    }

    private BigDecimal calcTotalSalesIncome() {
        BigDecimal totalIncome = BigDecimal.valueOf(0);

        for (SalesOrder salesOrder : salesOrderService.getOrders()) {
            totalIncome = totalIncome.add(salesOrder.getTotalPrice());
        }

        return totalIncome;
    }
}
