package com.accelex.sample.exercise.mapper;

import com.accelex.sample.exercise.domain.Customer;
import com.accelex.sample.exercise.domain.Rental;
import com.accelex.sample.exercise.domain.RentalStatus;
import com.accelex.sample.exercise.domain.Vehicle;
import com.accelex.sample.exercise.dto.RentalDto;
import com.accelex.sample.exercise.dto.RentalRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RentalMapper {

    public RentalDto map(Rental model){
        RentalDto dto = new RentalDto();
        dto.setId(model.getId());
        dto.setStatus(model.getStatus());
        dto.setRequest(mapRequest(model));
        return dto;
    }

    public Rental map(RentalRequestDto dto){
        Rental model = new Rental();
        model.setStatus(RentalStatus.PENDING);
        model.setCustomer(minimalCustomer(dto.getCustomerId()));
        model.setVehicle(minimalVehicle(dto.getVehicleId()));
        model.setStartDate(dto.getStartDate());
        model.setEndDate(dto.getEndDate());
        return model;
    }

    public List<RentalDto> map(List<Rental> models){
        return models.stream().map(this::map).collect(Collectors.toList());
    }

    private Vehicle minimalVehicle(Long id) {
        Vehicle model = new Vehicle();
        model.setId(id);
        return model;
    }

    private Customer minimalCustomer(Long id){
        Customer model = new Customer();
        model.setId(id);
        return model;
    }

    private RentalRequestDto mapRequest(Rental model){
        RentalRequestDto dto = new RentalRequestDto();
        dto.setCustomerId(model.getCustomer().getId());
        dto.setVehicleId(model.getVehicle().getId());
        dto.setStartDate(model.getStartDate());
        dto.setEndDate(model.getEndDate());
        return dto;
    }

}
