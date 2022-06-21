package com.ibm.test.first_project.controller;

import com.ibm.test.first_project.data.dtos.*;
import com.ibm.test.first_project.exceptions.BikeNotFoundException;
import com.ibm.test.first_project.services.BikeService;
import com.ibm.test.first_project.utils.CustomModelMapper;
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
    private final CustomModelMapper customModelMapper;

    @GetMapping
    public ResponseEntity<List<BikeGetResDTO>> getBikes(@RequestParam(value = "brand", required = false) String brand) {
        return brand == null ?
                ResponseEntity.ok(customModelMapper.mapList(bikeService.getAllBikes(), BikeGetResDTO.class)) :
                ResponseEntity.ok(customModelMapper.mapList(bikeService.getAllBikes(brand), BikeGetResDTO.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BikeGetResDTO> getBike(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(customModelMapper.map(bikeService.getBike(id), BikeGetResDTO.class));
        } catch (BikeNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<BikeCreateResDTO> createBike(@RequestBody BikeCreateReqDTO bike) {
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/bikes")
                .toUriString());

        return ResponseEntity.created(uri).body(customModelMapper.map(bikeService.storeBike(bike), BikeCreateResDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BikeUpdateResDTO> updateBike(@PathVariable("id") Long id, @RequestBody BikeUpdateReqDTO bike) {
        try {
            return ResponseEntity.ok(customModelMapper.map(bikeService.updateBike(id, bike), BikeUpdateResDTO.class));
        } catch (BikeNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
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
