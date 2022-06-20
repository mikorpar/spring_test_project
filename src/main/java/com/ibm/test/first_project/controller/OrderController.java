 package com.ibm.test.first_project.controller;


 import com.ibm.test.first_project.data.dtos.OrderItemCreateReq;
 import com.ibm.test.first_project.data.models.SalesOrder;
 import com.ibm.test.first_project.services.SalesOrderService;
 import lombok.RequiredArgsConstructor;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.*;

 import java.time.LocalDate;
 import java.util.List;

 @RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final SalesOrderService salesOrderService;

    @PostMapping
    public ResponseEntity<SalesOrder> createReceipt(@RequestBody List<OrderItemCreateReq> items) {
        return ResponseEntity.ok(salesOrderService.storeOrder(items));
    }

    @GetMapping
    public ResponseEntity<List<SalesOrder>> getReceipts(@RequestParam(value = "date", required = false) LocalDate date) {
        return date == null ? ResponseEntity.ok(salesOrderService.getOrders()) : ResponseEntity.ok(salesOrderService.getOrders(date));
    }
}
