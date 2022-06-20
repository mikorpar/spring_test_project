package com.ibm.test.first_project.services;

import com.ibm.test.first_project.data.dtos.StatisticsGetRes;
import com.ibm.test.first_project.data.models.Bike;
import com.ibm.test.first_project.data.models.OrderItem;
import com.ibm.test.first_project.data.models.SalesOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
@Service
@RequiredArgsConstructor
public class StatisticsService {

    private final SalesOrderService salesOrderService;
    private final BikeService bikeService;

    // TODO statistika prodaje bicikala, servis koji vraća ukupnu vrijednost svih prodanih bicikala
    //  te postotak cijene u ukupnoj cijeni svih prodanih bicikala za tekucu godinu po marki, boji
    private BigDecimal calcTotalSalesIncome() {
        BigDecimal totalIncome = BigDecimal.valueOf(0);

        for (SalesOrder salesOrder : salesOrderService.getOrders()) {
            totalIncome = totalIncome.add(salesOrder.getTotalPrice());
        }

        return totalIncome;
    }

    public StatisticsGetRes calcTotalSalesIncomeByBrand(String brand) {
        BigDecimal totalIncome = calcTotalSalesIncome();
        BigDecimal totalIncomeByBrand = BigDecimal.valueOf(0);

        for (Bike bike : bikeService.getAllBikesByBrand(brand)) {
            for (OrderItem item : bike.getItems()) {
                totalIncomeByBrand = totalIncomeByBrand.add(item.getBike().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
            }
        }

        StatisticsGetRes stastistics = new StatisticsGetRes();
        stastistics.setTotalIncome(totalIncome);
        stastistics.setPercentage(totalIncomeByBrand.divide(totalIncome, 2, RoundingMode.HALF_UP).doubleValue() * 100);

        return stastistics;
    }

    public StatisticsGetRes calcTotalSalesIncomeByColor(String color) {
        BigDecimal totalIncome = calcTotalSalesIncome();
        BigDecimal totalIncomeByColor = BigDecimal.valueOf(0);

        for (Bike bike : bikeService.getAllBikesByColor(color)) {
            for (OrderItem item : bike.getItems()) {
                totalIncomeByColor = totalIncomeByColor.add(item.getBike().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
            }
        }

        StatisticsGetRes stastistics = new StatisticsGetRes();
        stastistics.setTotalIncome(totalIncome);
        stastistics.setPercentage(totalIncomeByColor.divide(totalIncome, 2, RoundingMode.HALF_UP).doubleValue() * 100);

        return stastistics;
    }

    public StatisticsGetRes calcTotalSalesIncomeByBrandAndColor(String brand, String color) {
        BigDecimal totalIncome = calcTotalSalesIncome();
        BigDecimal totalIncomeByBrandAndColor = BigDecimal.valueOf(0);

        for (Bike bike : bikeService.getAllBikesByBrandAndColor(brand, color)) {
            for (OrderItem item : bike.getItems()) {
                totalIncomeByBrandAndColor = totalIncomeByBrandAndColor.add(item.getBike().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
            }
        }

        StatisticsGetRes stastistics = new StatisticsGetRes();
        stastistics.setTotalIncome(totalIncome);
        stastistics.setPercentage(totalIncomeByBrandAndColor.divide(totalIncome, 2, RoundingMode.HALF_UP).doubleValue() * 100);

        return stastistics;
    }
}
