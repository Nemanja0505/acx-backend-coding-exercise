package com.accelex.sample.exercise.service;

import com.accelex.sample.exercise.domain.Rental;
import com.accelex.sample.exercise.domain.Vehicle;
import com.accelex.sample.exercise.dto.CurrentRentedVehicleDto;
import com.accelex.sample.exercise.dto.VehicleDto;
import com.accelex.sample.exercise.mapper.VehicleMapper;
import com.accelex.sample.exercise.repository.VehicleRepository;
import com.accelex.sample.exercise.service.interfaces.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper mapper;

    @Override
    public VehicleDto save(VehicleDto dto) {
        Vehicle vehicle = vehicleRepository.save(mapper.map(dto));
        return mapper.map(vehicle);
    }

    @Override
    public List<CurrentRentedVehicleDto> getCurrentRentedVehicles() {
        List<Object[]> objects = vehicleRepository.getCurrentRentedVehicles();
        return  objects.stream().map(el -> mapper.map((Vehicle) el[0], (Rental)el[1])).collect(Collectors.toList()) ;
    }

    @Override
    public List<VehicleDto> getAll() {
        return mapper.map(vehicleRepository.findAll());
    }

}
