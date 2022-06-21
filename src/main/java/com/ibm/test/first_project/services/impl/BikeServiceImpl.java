package com.ibm.test.first_project.services.impl;

import com.ibm.test.first_project.data.dtos.BikeCreateReq;
import com.ibm.test.first_project.data.dtos.BikeUpdateReq;
import com.ibm.test.first_project.data.models.Bike;
import com.ibm.test.first_project.data.repositories.BikeRepository;
import com.ibm.test.first_project.exceptions.BikeNotFoundException;
import com.ibm.test.first_project.services.BikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BikeServiceImpl implements BikeService {

    private final BikeRepository bikeRepository;

    @Override
    public Bike storeBike(BikeCreateReq bikeDTO) {
        Bike bike = new Bike();
        bike.setName(bikeDTO.getName());
        bike.setBrand(bikeDTO.getBrand());
        bike.setPrice(bikeDTO.getPrice());
        bike.setColor(bikeDTO.getColor());

        return bikeRepository.save(bike);
    }

    @Override
    public List<Bike> getAllBikes() {
        return bikeRepository.findAll();
    }

    @Override
    public List<Bike> getAllBikes(String brand) {
        return bikeRepository.findAllByBrand(brand);
    }

    @Override
    public List<Bike> getAllBikesByBrandOrderedThisYear(String brand) {
        return bikeRepository.findAllByBrandAndOrderedThisYear(brand);
    }

    @Override
    public List<Bike> getAllBikesByColorOrderedThisYear(String color) {
        return bikeRepository.findAllByColorAndOrderedThisYear(color);
    }

    @Override
    public List<Bike> getAllBikesByBrandAndColorOrderedThisYear(String brand, String color) {
        return bikeRepository.findAllByBrandAndColorAndOrderedThisYear(brand, color);
    }

    @Override
    public Bike getBike(Long id) throws BikeNotFoundException {
        return bikeRepository
                .findById(id)
                .orElseThrow(() -> new BikeNotFoundException(String.format("Bike with id: '%d' not found.", id)));
    }

    @Override
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

    @Override
    public void deleteBike(Long id) throws BikeNotFoundException {
        if (!bikeRepository.existsById(id)) {
            throw new BikeNotFoundException(String.format("Bike with id: '%d' not found.", id));
        }

        bikeRepository.deleteById(id);
    }
}