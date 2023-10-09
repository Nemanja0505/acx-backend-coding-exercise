package com.accelex.sample.exercise.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import static com.accelex.sample.exercise.validators.ValidationMessages.FIELD_CAN_NOT_BE_EMPTY;
import static com.accelex.sample.exercise.validators.ValidationMessages.YEAR_GREATER_THEN_1900;

@Setter
@Getter
public class VehicleDto {

    private Long id;

    @NotBlank(message = FIELD_CAN_NOT_BE_EMPTY)
    private String brand;

    @NotBlank(message = FIELD_CAN_NOT_BE_EMPTY)
    private String model;

    @Min(value = 1900,message = YEAR_GREATER_THEN_1900)
    private int year;

    @NotBlank(message = FIELD_CAN_NOT_BE_EMPTY)
    private String colour;

    @NotBlank(message = FIELD_CAN_NOT_BE_EMPTY)
    private String registration;
}
