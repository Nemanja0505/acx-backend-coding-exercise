package com.accelex.sample.exercise.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrentRentedVehicleDto {

    private VehicleDto vehicle;
    private RentalDto rental;

}
