package com.accelex.sample.exercise.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static com.accelex.sample.exercise.validators.ValidationMessages.BIRTH_DAY_MUST_BE_IN_PAST;
import static com.accelex.sample.exercise.validators.ValidationMessages.FIELD_CAN_NOT_BE_EMPTY;

@Getter
@Setter
public class CustomerDto {

    private Long id;

    @NotBlank(message = FIELD_CAN_NOT_BE_EMPTY)
    private String firstName;

    @NotBlank(message = FIELD_CAN_NOT_BE_EMPTY)
    private String lastName;

    @Past(message = BIRTH_DAY_MUST_BE_IN_PAST)
    private LocalDate birthDate;

    @NotBlank(message = FIELD_CAN_NOT_BE_EMPTY)
    private String driverLicenseNumber;

}
