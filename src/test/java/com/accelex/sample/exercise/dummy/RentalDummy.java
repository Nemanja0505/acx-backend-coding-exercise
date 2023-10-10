package com.accelex.sample.exercise.dummy;

import com.accelex.sample.exercise.dto.RentalRequestDto;

import java.time.LocalDate;

public class RentalDummy {

    public static RentalRequestDto createDummyRentalRequestDto(){
        RentalRequestDto dto = new RentalRequestDto();
        dto.setCustomerId(4L);
        dto.setVehicleId(3L);
        LocalDate now  = LocalDate.now();
        dto.setStartDate(now.plusDays(1));
        dto.setEndDate(now.plusDays(10));
        return dto;
    }

}
