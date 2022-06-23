package com.ibm.test.first_project.services.impl;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.ibm.test.first_project.data.dtos.bike.BikeCreateReqDTO;
import com.ibm.test.first_project.data.dtos.bike.BikeUpdateReqDTO;
import com.ibm.test.first_project.data.models.Bike;
import com.ibm.test.first_project.data.models.Brand;
import com.ibm.test.first_project.data.models.Color;
import com.ibm.test.first_project.data.repositories.BikeRepository;
import com.ibm.test.first_project.data.repositories.BrandRepository;
import com.ibm.test.first_project.data.repositories.ColorRepository;
import com.ibm.test.first_project.exceptions.BikeNotFoundException;
import com.ibm.test.first_project.services.BikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BikeServiceImpl implements BikeService {

    private final BikeRepository bikeRepository;

    private final BrandRepository brandRepository;

    private final ColorRepository colorRepository;

    @Override
    public Bike storeBike(BikeCreateReqDTO bikeDTO) {
        Bike bike = new Bike();



//        Brand brand = brandRepository.findByName(bikeDTO.getBrand());
//        if (brand == null) {
//            brand = new Brand();
//            brand.setName(bikeDTO.getBrand());
//            brand = brandRepository.save(brand);
//        }
//
//        Color color = colorRepository.findByName(bikeDTO.getColor());
//        if (color == null) {
//            color = new Color();
//            color.setName(bikeDTO.getColor());
//            color = colorRepository.save(color);
//        }

        Brand brand = brandRepository.findByName("Scott");
        Color color = colorRepository.findByName("gray");

        bike.setName(bikeDTO.getName());
        bike.setBrand(brand);
        bike.setPrice(bikeDTO.getPrice());
        bike.setColor(color);

        return bikeRepository.save(bike);
    }

    public void testStoreColor () {
        Color color = new Color("tstColor");
        colorRepository.save(color);
    }

    @Override
    public void testStoreBrand() {
        Brand brand = new Brand("tstBrand");
        brandRepository.save(brand);
    }

    @Override
    public List<Bike> getAllBikes() {
        return bikeRepository.findAll();
    }

    @Override
    public List<Bike> getAllBikes(String brand) {
        return bikeRepository.findAllByBrandName(brand);
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
    public Bike updateBike(Long id, BikeUpdateReqDTO bikeDTO) throws BikeNotFoundException {
        Bike bike = bikeRepository
                .findById(id)
                .orElseThrow(() -> new BikeNotFoundException(String.format("Bike with id: '%d' not found.", id)));

        bike.setName(bikeDTO.getName());
        bike.setBrand(new Brand(bikeDTO.getBrand()));
        bike.setPrice(bikeDTO.getPrice());
        bike.setColor(new Color((bikeDTO.getColor())));

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
