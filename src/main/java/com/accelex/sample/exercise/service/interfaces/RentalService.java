package com.accelex.sample.exercise.service.interfaces;

import com.accelex.sample.exercise.dto.RentalDto;
import com.accelex.sample.exercise.dto.RentalRequestDto;
import com.accelex.sample.exercise.dto.ReturnVehicleDto;

import java.util.List;

public interface RentalService {

    RentalDto createRentalRequest(RentalRequestDto dto);
    Boolean approveRentalRequest(Long id);
    Boolean returnVehicle(ReturnVehicleDto dto);
    List<RentalDto> getAllRentalRequests();
}
