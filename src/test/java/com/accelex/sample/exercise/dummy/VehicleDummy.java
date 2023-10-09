package com.accelex.sample.exercise.dummy;

import com.accelex.sample.exercise.dto.VehicleDto;

public class VehicleDummy {

    public static VehicleDto createDummyInvalidVehicleDto(){
        return new VehicleDto();
    }

    public static VehicleDto createDummyValidVehicleDto(){
        VehicleDto dto = new VehicleDto();
        dto.setModel("Dummy model");
        dto.setBrand("Dummy brand");
        dto.setColour("Dummy colour");
        dto.setYear(1999);
        dto.setRegistration("Dummy registration");
        return dto;
    }
}
