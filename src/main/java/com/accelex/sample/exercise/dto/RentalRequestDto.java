package com.accelex.sample.exercise.dto;

import com.accelex.sample.exercise.validators.CompareDate;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static com.accelex.sample.exercise.validators.ValidationMessages.*;

@Setter
@Getter
@CompareDate(before = "startDate", after = "endDate", message = START_DATE_MUST_BE_LOWER_THEN_END_DATE)
public class RentalRequestDto {

    @NotNull(message = FIELD_CAN_NOT_BE_EMPTY)
    private Long vehicleId;

    @NotNull(message = FIELD_CAN_NOT_BE_EMPTY)
    private Long customerId;

    @NotNull(message = FIELD_CAN_NOT_BE_EMPTY)
    @FutureOrPresent(message = RENTAL_REQUEST_START_DATE)
    private LocalDate startDate;

    @NotNull(message = FIELD_CAN_NOT_BE_EMPTY)
    @Future(message = RENTAL_REQUEST_END_DATE)
    private LocalDate endDate;

}
