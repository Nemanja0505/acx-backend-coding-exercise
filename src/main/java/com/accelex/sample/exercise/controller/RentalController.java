package com.accelex.sample.exercise.controller;

import com.accelex.sample.exercise.dto.RentalDto;
import com.accelex.sample.exercise.dto.RentalRequestDto;
import com.accelex.sample.exercise.dto.ResponseDto;
import com.accelex.sample.exercise.dto.ReturnVehicleDto;
import com.accelex.sample.exercise.service.interfaces.RentalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.accelex.sample.exercise.dto.ResponseDto.*;


@RestController
@RequestMapping("/api/rental")
@RequiredArgsConstructor
public class RentalController {

    private final RentalService rentalService;

    @GetMapping("/all/requests")
    public ResponseEntity<?> getAllRentalRequests(){
        return new ResponseEntity<>(rentalService.getAllRentalRequests(),HttpStatus.OK);
    }

    @PostMapping("/request")
    public ResponseEntity<?> createRentalRequest(@RequestBody @Valid RentalRequestDto rentalRequestDto){
        RentalDto rentalDto = rentalService.createRentalRequest(rentalRequestDto);
        if(rentalDto != null){
            return new ResponseEntity<>(rentalDto, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new ResponseDto(CREATE_RENTAL_REQUEST_UNSUCCESSFULLY),HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/approve/request/{id}")
    public ResponseEntity<ResponseDto> approveRentalRequest(@PathVariable Long id){
        if(rentalService.approveRentalRequest(id)){
            return new ResponseEntity<>(new ResponseDto(APPROVED_RENTAL_REQUEST_SUCCESSFULLY), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ResponseDto(APPROVED_RENTAL_REQUEST_UNSUCCESSFULLY),HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/return/vehicle")
    public ResponseEntity<ResponseDto> returnVehicle(@RequestBody @Valid ReturnVehicleDto dto){
        if(rentalService.returnVehicle(dto)){
            return new ResponseEntity<>(new ResponseDto(RETURNED_VEHICLE_SUCCESSFULLY),HttpStatus.OK);
        }
        return new ResponseEntity<>(new ResponseDto(RETURNED_VEHICLE_UNSUCCESSFULLY),HttpStatus.BAD_REQUEST);
    }

}
