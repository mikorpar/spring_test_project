package com.ibm.test.first_project.services;

import com.ibm.test.first_project.data.dtos.BikeCreateDTO;
import com.ibm.test.first_project.data.dtos.BikeUpdateDTO;
import com.ibm.test.first_project.data.models.Bike;
import com.ibm.test.first_project.data.repositories.BikeRepository;
import com.ibm.test.first_project.exceptions.BikeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BikeService {

    private final BikeRepository bikeRepository;

    public Bike storeBike(BikeCreateDTO bikeDTO) {
        // TODO save bike to DB

        Bike bike = new Bike();
        bike.setName(bikeDTO.getName());
        bike.setBrand(bikeDTO.getBrand());
        bike.setPrice(bikeDTO.getPrice());
        bike.setColor(bikeDTO.getColor());

        return bikeRepository.save(bike);
    }

    public List<Bike> getAllBikes(String brand) {
        if (brand.isEmpty()) {
            return bikeRepository.findAll();
        } else {
            return bikeRepository.findAllByBrand(brand);
        }
    }

    public Bike getBike(Long id) throws BikeNotFoundException {
        return bikeRepository
                .findById(id)
                .orElseThrow(() -> new BikeNotFoundException(String.format("Bike with id: '%d' not found.", id)));
    }

    public Bike updateBike(Long id, BikeUpdateDTO bikeDTO) throws BikeNotFoundException {
        Bike bike = bikeRepository
                .findById(id)
                .orElseThrow(() -> new BikeNotFoundException(String.format("Bike with id: '%d' not found.", id)));

        bike.setName(bikeDTO.getName());
        bike.setBrand(bikeDTO.getBrand());
        bike.setPrice(bikeDTO.getPrice());
        bike.setColor(bikeDTO.getColor());

        return bikeRepository.save(bike);
    }

    public void deleteBike(Long id) throws BikeNotFoundException {
        if (!bikeRepository.existsById(id)) {
            throw new BikeNotFoundException(String.format("Bike with id: '%d' not found.", id));
        }

        bikeRepository.deleteById(id);
    }
}
