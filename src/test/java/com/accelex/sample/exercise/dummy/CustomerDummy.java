package com.accelex.sample.exercise.dummy;

import com.accelex.sample.exercise.dto.CustomerDto;

public class CustomerDummy {

    public static CustomerDto createDummyInvalidCustomerDto(){
        return new CustomerDto();
    }

    public static CustomerDto createDummyValidCustomerDto(){
        CustomerDto dto = new CustomerDto();
        dto.setFirstName("Dummy firstName");
        dto.setLastName("Dummy lastName");
        dto.setDriverLicenseNumber("Dummy license number");
        return dto;
    }

}
