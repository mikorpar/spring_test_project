package com.ibm.test.first_project.controller;


import com.ibm.test.first_project.data.dtos.ReceiptBikePostReqDTO;
import com.ibm.test.first_project.data.dtos.ReceiptGetResDTO;
import com.ibm.test.first_project.data.dtos.ReceiptPostReqDTO;
import com.ibm.test.first_project.services.ReceiptService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/receipts")
@RequiredArgsConstructor
public class ReceiptController {

    private final ReceiptService receiptService;

    @PostMapping
    public ResponseEntity<ReceiptPostReqDTO> createReceipt(List<ReceiptBikePostReqDTO> bikes) {
        return ResponseEntity.ok(receiptService.storeReceipt(bikes));
    }

    @GetMapping
    public ResponseEntity<List<ReceiptGetResDTO>> getReceipts() {
        return ResponseEntity.ok(receiptService.getReceipts());
    }
}
