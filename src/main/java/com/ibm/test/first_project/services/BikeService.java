package com.ibm.test.first_project.services;

import com.ibm.test.first_project.data.dtos.bike.BikeCreateReqDTO;
import com.ibm.test.first_project.data.dtos.bike.BikeUpdateReqDTO;
import com.ibm.test.first_project.data.models.Bike;
import com.ibm.test.first_project.exceptions.BikeNotFoundException;

import java.util.List;

public interface BikeService {

    Bike storeBike(BikeCreateReqDTO bikeDTO);

    List<Bike> getAllBikes();

    List<Bike> getAllBikes(String brand);

    List<Bike> getAllBikesByBrandOrderedThisYear(String brand);

    List<Bike> getAllBikesByColorOrderedThisYear(String color);

    List<Bike> getAllBikesByBrandAndColorOrderedThisYear(String brand, String color);

    Bike getBike(Long id) throws BikeNotFoundException;

    Bike updateBike(Long id, BikeUpdateReqDTO bikeDTO) throws BikeNotFoundException;

    void deleteBike(Long id) throws BikeNotFoundException;
}
