package com.accelex.sample.exercise.service.interfaces;

import com.accelex.sample.exercise.domain.Vehicle;
import com.accelex.sample.exercise.dto.CurrentRentedVehicleDto;
import com.accelex.sample.exercise.dto.VehicleDto;

import java.util.List;

public interface VehicleService {

    VehicleDto save(VehicleDto dto);
    List<CurrentRentedVehicleDto> getCurrentRentedVehicles();
    List<VehicleDto> getAll();
}
