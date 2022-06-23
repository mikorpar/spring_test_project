package com.ibm.test.first_project.data.dtos.sales_order;

import com.ibm.test.first_project.data.models.Bike;
import lombok.Data;

@Data
public class OrderItemCreateReqDTO {
    Bike bike;
    Integer quantity;
}
