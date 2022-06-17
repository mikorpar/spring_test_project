package com.ibm.test.first_project.data.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
public class ReceiptGetResDTO {
    private Long id;
    private Instant createdAt;
    private List<ItemResDTO> items;
    private BigDecimal totalPrice;
}