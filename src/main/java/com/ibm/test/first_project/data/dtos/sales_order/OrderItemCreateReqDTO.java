package com.ibm.test.first_project.data.dtos.sales_order;

import lombok.Data;

@Data
public class OrderItemCreateReqDTO {
    Long bikeId;
    Integer quantity;
}

