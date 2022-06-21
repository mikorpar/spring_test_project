package com.ibm.test.first_project.services;

import com.ibm.test.first_project.data.dtos.BikeCreateReq;
import com.ibm.test.first_project.data.dtos.BikeUpdateReq;
import com.ibm.test.first_project.data.models.Bike;
import com.ibm.test.first_project.exceptions.BikeNotFoundException;

import java.util.List;

public interface BikeService {

    Bike storeBike(BikeCreateReq bikeDTO);

    List<Bike> getAllBikes();

    List<Bike> getAllBikes(String brand);

    List<Bike> getAllBikesByBrandOrderedThisYear(String brand);

    List<Bike> getAllBikesByColorOrderedThisYear(String color);

    List<Bike> getAllBikesByBrandAndColorOrderedThisYear(String brand, String color);

    Bike getBike(Long id) throws BikeNotFoundException;

    Bike updateBike(Long id, BikeUpdateReq bikeDTO) throws BikeNotFoundException;

    void deleteBike(Long id) throws BikeNotFoundException;
}
