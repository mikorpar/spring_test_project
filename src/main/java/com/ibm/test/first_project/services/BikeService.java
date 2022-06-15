package com.ibm.test.first_project.services;

import com.ibm.test.first_project.data.dtos.BikeCreateDTO;
import com.ibm.test.first_project.data.dtos.BikeUpdateDTO;
import com.ibm.test.first_project.data.models.Bike;
import com.ibm.test.first_project.exceptions.BikeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {

    public Bike storeBike(BikeCreateDTO bike) {
        // TODO save bike to DB

        return null;
    }

    public List<Bike> getAllBikes(String brand) {
        if (brand == null) {
            // TODO return all bikes from DB

            return null;
        } else {
            // TODO return all bikes where brand equals supplied brand

            return null;
        }
    }

    public Bike getBike(int id) throws BikeNotFoundException {
        if (getBike(id) == null) {
            throw new BikeNotFoundException(String.format("Bike with id: '%d' not found.", id));
        }

        // TODO return bike with supplied id
        return null;
    }

    public Bike updateBike(int id, BikeUpdateDTO bike) throws BikeNotFoundException {
        if (getBike(id) == null) {
            throw new BikeNotFoundException(String.format("Bike with id: '%d' not found.", id));
        }

        // TODO update bike properties in DB
        return null;
    }

    public void deleteBike(int id) throws BikeNotFoundException {
        if (getBike(id) == null) {
            throw new BikeNotFoundException(String.format("Bike with id: '%d' not found.", id));
        }

        // TODO delete bike in DB
    }
}
