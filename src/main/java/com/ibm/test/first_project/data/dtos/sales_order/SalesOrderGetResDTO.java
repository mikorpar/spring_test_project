package com.ibm.test.first_project.data.dtos.sales_order;

import com.ibm.test.first_project.data.models.OrderItem;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
public class SalesOrderGetResDTO {
    private Long id;
    private Instant createdAt;
    private BigDecimal totalPrice;
    private List<OrderItemResDTO> items;
}
