package com.ibm.test.first_project.controller;

import com.ibm.test.first_project.data.dtos.BikeCreateReq;
import com.ibm.test.first_project.data.dtos.BikeUpdateReq;
import com.ibm.test.first_project.data.models.Bike;
import com.ibm.test.first_project.exceptions.BikeNotFoundException;
import com.ibm.test.first_project.services.BikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Validated
@RestController
@RequestMapping("/bikes")
@RequiredArgsConstructor
public class BikeController {

    private final BikeService bikeService;

    @GetMapping
    public ResponseEntity<List<Bike>> getBikes(@RequestParam(value = "brand", required = false) String brand) {
        return brand == null ? ResponseEntity.ok(bikeService.getAllBikes()) : ResponseEntity.ok(bikeService.getAllBikes(brand));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bike> getBike(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(bikeService.getBike(id));
        } catch (BikeNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Bike> createBike(@RequestBody BikeCreateReq bike) {
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/bikes")
                .toUriString());

        return ResponseEntity.created(uri).body(bikeService.storeBike(bike));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bike> updateBike(@PathVariable("id") Long id, @RequestBody BikeUpdateReq bike) {
        Bike updatedBike;

        try {
            updatedBike = bikeService.updateBike(id, bike);
        } catch (BikeNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

        return ResponseEntity.ok(updatedBike);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBike(@PathVariable("id") Long id) {
        try {
            bikeService.deleteBike(id);
        } catch (BikeNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping("/test")
    public ResponseEntity<List<Bike>> test() {
        return ResponseEntity.ok(bikeService.test());
    }
}
