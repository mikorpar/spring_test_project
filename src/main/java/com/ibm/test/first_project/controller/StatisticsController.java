package com.ibm.test.first_project.controller;

import com.ibm.test.first_project.data.dtos.Statistics;
import com.ibm.test.first_project.services.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/statistics")
@RequiredArgsConstructor
public class StatisticsController {

    private final StatisticsService statisticsService;

    @GetMapping
    public ResponseEntity<Statistics> getTotalSalesIncome(
            @RequestParam(value = "brand", required = false) String brand,
            @RequestParam(value = "color", required = false) String color) {

        if (brand == null && color == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "At least one parameter must be specified!");
        } else if (brand != null && color == null) {
            return ResponseEntity.ok(statisticsService.calcTotalSalesIncomeByBrand(brand));
        } else if (brand == null && color != null) {
            return ResponseEntity.ok(statisticsService.calcTotalSalesIncomeByColor(color));
        } else { // (brand != null && color != null)
            return ResponseEntity.ok(statisticsService.calcTotalSalesIncomeByBrandAndColor(brand, color));
        }
    }
}
