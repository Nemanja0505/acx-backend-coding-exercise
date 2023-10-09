package com.accelex.sample.exercise.dto;

import com.accelex.sample.exercise.domain.RentalStatus;
import com.accelex.sample.exercise.validators.RentalStatusReturnedVehicle;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import static com.accelex.sample.exercise.validators.ValidationMessages.FIELD_CAN_NOT_BE_EMPTY;

@Getter
@Setter
public class ReturnVehicleDto {

    @NotNull(message = FIELD_CAN_NOT_BE_EMPTY)
    private Long rentalId;

    @NotNull(message = FIELD_CAN_NOT_BE_EMPTY)
    @RentalStatusReturnedVehicle()
    private RentalStatus status;

}
