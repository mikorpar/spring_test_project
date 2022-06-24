package com.ibm.test.first_project.data.dtos.sales_order;

import com.ibm.test.first_project.data.dtos.bike.BikeGetResDTO;
import lombok.Data;

@Data
public class OrderItemResDTO {
    BikeGetResDTO bike;
    Integer quantity;
}