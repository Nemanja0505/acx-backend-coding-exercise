package com.accelex.sample.exercise.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseDto {

    public static final String CREATE_RENTAL_REQUEST_UNSUCCESSFULLY ="There is already a rental request for the vehicle with same ID at the overlapping time.";
    public static final String APPROVED_RENTAL_REQUEST_SUCCESSFULLY = "Approved rental request";
    public static final String APPROVED_RENTAL_REQUEST_UNSUCCESSFULLY = "Rental request is already approved or vehicle is already in use";
    public static final String RETURNED_VEHICLE_SUCCESSFULLY = "Vehicle is returned!";
    public static final String RETURNED_VEHICLE_UNSUCCESSFULLY = "Vehicle is already returned or is not yet rented";

    private String message;

}
