package com.ibm.test.first_project.services;

import com.ibm.test.first_project.data.dtos.sales_order.OrderItemCreateReqDTO;
import com.ibm.test.first_project.data.models.SalesOrder;
import java.time.LocalDate;
import java.util.List;

public interface SalesOrderService {

    SalesOrder storeOrder(List<OrderItemCreateReqDTO> itemsDTO);

    List<SalesOrder> getOrders();

    List<SalesOrder> getOrders(LocalDate date);
}
