 package com.ibm.test.first_project.controller;


 import com.ibm.test.first_project.data.dtos.sales_order.OrderItemCreateReqDTO;
 import com.ibm.test.first_project.data.dtos.sales_order.SalesOrderGetResDTO;
 import com.ibm.test.first_project.data.dtos.sales_order.SalesOrderPostResDTO;
 import com.ibm.test.first_project.services.SalesOrderService;
 import com.ibm.test.first_project.utils.CustomModelMapper;
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
    private final CustomModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<SalesOrderPostResDTO> createOrder(@RequestBody List<OrderItemCreateReqDTO> items) {
        return ResponseEntity.ok(modelMapper.map(salesOrderService.storeOrder(items), SalesOrderPostResDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<SalesOrderGetResDTO>> getOrders(@RequestParam(value = "date", required = false) LocalDate date) {
        return date == null ?
                ResponseEntity.ok(modelMapper.mapList(salesOrderService.getOrders(), SalesOrderGetResDTO.class)) :
                ResponseEntity.ok(modelMapper.mapList(salesOrderService.getOrders(date), SalesOrderGetResDTO.class));
    }
}
