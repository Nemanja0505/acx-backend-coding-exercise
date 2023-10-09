package com.accelex.sample.exercise.controller;

import com.accelex.sample.exercise.dto.VehicleDto;
import com.accelex.sample.exercise.service.interfaces.VehicleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/vehicle")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(vehicleService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/all-current-rented")
    public ResponseEntity<?> getCurrentRentedVehicles(){
        return new ResponseEntity<>(vehicleService.getCurrentRentedVehicles(),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createVehicle(@RequestBody @Valid VehicleDto dto){
        VehicleDto savedVehicle = vehicleService.save(dto);
        return new ResponseEntity<>(savedVehicle, HttpStatus.CREATED);
    }


}
