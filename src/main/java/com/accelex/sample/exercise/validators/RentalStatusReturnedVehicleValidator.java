package com.accelex.sample.exercise.validators;

import com.accelex.sample.exercise.domain.RentalStatus;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RentalStatusReturnedVehicleValidator implements ConstraintValidator<RentalStatusReturnedVehicle,RentalStatus> {

    @Override
    public boolean isValid(RentalStatus status, ConstraintValidatorContext constraintValidatorContext) {
        return status.equals(RentalStatus.RETURNED_OK) || status.equals(RentalStatus.RETURNED_DAMAGED);
    }
}
