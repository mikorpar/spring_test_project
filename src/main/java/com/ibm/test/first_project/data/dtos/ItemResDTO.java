package com.ibm.test.first_project.data.dtos;

import com.ibm.test.first_project.data.models.Bike;
import lombok.Data;

@Data
public class ItemResDTO {
    private Bike bike;
    private int quantity;
}
