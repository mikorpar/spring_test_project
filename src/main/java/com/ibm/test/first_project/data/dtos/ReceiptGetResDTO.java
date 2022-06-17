package com.ibm.test.first_project.data.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
public class ReceiptGetDTO {
    private Long id;
    private Instant createdAt;
    private List<ItemDTO> items;
    private BigDecimal totalPrice;
}