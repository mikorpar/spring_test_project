package com.ibm.test.first_project.services;

import com.ibm.test.first_project.data.dtos.OrderItemCreateReq;
import com.ibm.test.first_project.data.models.SalesOrder;
import com.ibm.test.first_project.data.models.OrderItem;
import com.ibm.test.first_project.data.repositories.SalesOrderRepository;
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
public class SalesOrderService {

    private final SalesOrderRepository salesOrderRepository;

    @Transactional
    public SalesOrder storeOrder(List<OrderItemCreateReq> itemsDTO) {

        SalesOrder salesOrder = new SalesOrder();
        salesOrderRepository.save(salesOrder);

        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderItemCreateReq itemDTO : itemsDTO) {
            OrderItem orderItem = new OrderItem();
            orderItem.setSalesOrder(salesOrder);
            orderItem.setBike(itemDTO.getBike());
            orderItem.setQuantity(itemDTO.getQuantity());

            orderItems.add(orderItem);
        }

        salesOrder.setItems(orderItems);
        return salesOrderRepository.save(salesOrder);
    }

    public List<SalesOrder> getOrders(LocalDate date) {
        if (date != null) {
            Instant startDate = date.atStartOfDay(ZoneId.systemDefault()).toInstant();
            Instant endDate = startDate.plus(Duration.ofDays(1));
            return salesOrderRepository.findOrdersByCreatedAtBetween(startDate, endDate);
        }

        return salesOrderRepository.findAll();
    }
}
