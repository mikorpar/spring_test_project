package com.ibm.test.first_project.services.impl;

import com.ibm.test.first_project.data.dtos.sales_order.OrderItemCreateReqDTO;
import com.ibm.test.first_project.data.models.SalesOrder;
import com.ibm.test.first_project.data.models.OrderItem;
import com.ibm.test.first_project.data.repositories.SalesOrderRepository;
import com.ibm.test.first_project.services.SalesOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesOrderServiceImpl implements SalesOrderService {

    private final SalesOrderRepository salesOrderRepository;

    @Override
    @Transactional
    public SalesOrder storeOrder(List<OrderItemCreateReqDTO> itemsDTO) {
        SalesOrder salesOrder = new SalesOrder();
        salesOrderRepository.save(salesOrder);

        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderItemCreateReqDTO itemDTO : itemsDTO) {
            OrderItem orderItem = new OrderItem();
            orderItem.setSalesOrder(salesOrder);
            orderItem.setBike(itemDTO.getBike());
            orderItem.setQuantity(itemDTO.getQuantity());

            orderItems.add(orderItem);
        }

        salesOrder.setItems(orderItems);
        return salesOrderRepository.save(salesOrder);
    }

    @Override
    public List<SalesOrder> getOrders() {
        return salesOrderRepository.findAll();
    }

    @Override
    public List<SalesOrder> getOrders(LocalDate date) {
        Instant startDate = date.atStartOfDay(ZoneId.systemDefault()).toInstant();
        Instant endDate = startDate.plus(Duration.ofDays(1));
        return salesOrderRepository.findOrdersByCreatedAtBetween(startDate, endDate);
    }
}
