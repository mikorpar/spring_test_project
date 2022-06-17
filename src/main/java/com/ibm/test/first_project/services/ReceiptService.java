package com.ibm.test.first_project.services;

import com.ibm.test.first_project.data.dtos.ItemResDTO;
import com.ibm.test.first_project.data.dtos.ReceiptBikePostReqDTO;
import com.ibm.test.first_project.data.dtos.ReceiptGetResDTO;
import com.ibm.test.first_project.data.dtos.ReceiptPostReqDTO;
import com.ibm.test.first_project.data.repositories.ReceiptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReceiptService {

    private final ReceiptRepository receiptRepository;

    public ReceiptPostReqDTO storeReceipt(List<ReceiptBikePostReqDTO> bikes) {
        return null;
    }

    public List<ReceiptGetResDTO> getReceipts() {
        List<ReceiptGetResDTO> result = new ArrayList<>();

        receiptRepository.findAll().forEach(receipt -> {
            ReceiptGetResDTO receiptDTO = new ReceiptGetResDTO();
            receiptDTO.setId(receipt.getId());
            receiptDTO.setCreatedAt(receipt.getCreatedAt());

            ArrayList<ItemResDTO> itemsDTO = new ArrayList<>();
            receipt.getItems().forEach(item -> {
               ItemResDTO itemDTO = new ItemResDTO();
               itemDTO.setBike(item.getBike());
               itemDTO.setQuantity(item.getQuantity());
               itemsDTO.add(itemDTO);
            });

            receiptDTO.setItems(itemsDTO);
            receiptDTO.setTotalPrice(receipt.getTotalPrice());
            result.add(receiptDTO);
        });

        return result;
    }
}
