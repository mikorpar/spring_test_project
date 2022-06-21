package com.ibm.test.first_project.services;

import com.ibm.test.first_project.data.dtos.OrderItemCreateReq;
import com.ibm.test.first_project.data.models.SalesOrder;
import java.time.LocalDate;
import java.util.List;

public interface SalesOrderService {

    SalesOrder storeOrder(List<OrderItemCreateReq> itemsDTO);

    List<SalesOrder> getOrders();

    List<SalesOrder> getOrders(LocalDate date);
}
