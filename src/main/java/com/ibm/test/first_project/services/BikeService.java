package com.ibm.test.first_project.services;

import com.ibm.test.first_project.data.dtos.BikeCreateReq;
import com.ibm.test.first_project.data.dtos.BikeUpdateReq;
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

    public Bike storeBike(BikeCreateReq bikeDTO) {
        // TODO save bike to DB

        Bike bike = new Bike();
        bike.setName(bikeDTO.getName());
        bike.setBrand(bikeDTO.getBrand());
        bike.setPrice(bikeDTO.getPrice());
        bike.setColor(bikeDTO.getColor());

        return bikeRepository.save(bike);
    }

    public List<Bike> getAllBikes() {
        return bikeRepository.findAll();
    }

    public List<Bike> getAllBikesByBrand(String brand) {
        return bikeRepository.findAllByBrand(brand);
    }

    public List<Bike> getAllBikesByColor(String color) {
        return bikeRepository.findAllByColor(color);
    }

    public List<Bike> getAllBikesByBrandAndColor(String brand, String color) {
        return bikeRepository.findAllByBrandAndColor(brand, color);
    }

    public Bike getBike(Long id) throws BikeNotFoundException {
        return bikeRepository
                .findById(id)
                .orElseThrow(() -> new BikeNotFoundException(String.format("Bike with id: '%d' not found.", id)));
    }

    public Bike updateBike(Long id, BikeUpdateReq bikeDTO) throws BikeNotFoundException {
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
