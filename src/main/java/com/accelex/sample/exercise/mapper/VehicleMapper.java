package com.accelex.sample.exercise.mapper;

import com.accelex.sample.exercise.domain.Rental;
import com.accelex.sample.exercise.domain.Vehicle;
import com.accelex.sample.exercise.dto.CurrentRentedVehicleDto;
import com.accelex.sample.exercise.dto.VehicleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class VehicleMapper {

    private final RentalMapper rentalMapper;

    public Vehicle map(VehicleDto dto){
        Vehicle model = new Vehicle();
        model.setBrand(dto.getBrand());
        model.setModel(dto.getModel());
        model.setColour(dto.getColour());
        model.setRegistration(dto.getRegistration());
        model.setYearProduction(dto.getYear());
        return model;
    }

    public VehicleDto map(Vehicle model){
        VehicleDto dto = new VehicleDto();
        dto.setId(model.getId());
        dto.setBrand(model.getBrand());
        dto.setModel(model.getModel());
        dto.setColour(model.getColour());
        dto.setRegistration(model.getRegistration());
        dto.setYear(model.getYearProduction());
        return dto;
    }

    public CurrentRentedVehicleDto map(Vehicle vehicle, Rental rental){
        CurrentRentedVehicleDto dto = new CurrentRentedVehicleDto();
        dto.setVehicle(map(vehicle));
        dto.setRental(rentalMapper.map(rental));
        return dto;
    }

    public List<VehicleDto> map(List<Vehicle> models){
        return models.stream().map(this::map).collect(Collectors.toList());
    }

}
