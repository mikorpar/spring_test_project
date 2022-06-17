package com.ibm.test.first_project.controller;

import com.ibm.test.first_project.data.dtos.BikeCreateReqDTO;
import com.ibm.test.first_project.data.dtos.BikeUpdateReqDTO;
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
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/bikes")
@RequiredArgsConstructor
public class BikeController {

    private final BikeService bikeService;

    @GetMapping
    public ResponseEntity<List<Bike>> getBikes(@RequestParam("brand") Optional<String> brand) {
        return ResponseEntity.ok(bikeService.getAllBikes(brand.orElse("")));
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
    public ResponseEntity<Bike> createBike(@RequestBody BikeCreateReqDTO bike) {
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/bikes")
                .toUriString());

        return ResponseEntity.created(uri).body(bikeService.storeBike(bike));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bike> updateBike(@PathVariable("id") Long id, @RequestBody BikeUpdateReqDTO bike) {
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
}
