package com.accelex.sample.exercise.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.accelex.sample.exercise.validators.ValidationMessages.RETURN_VEHICLE_RENTAL_STATUS;

@Constraint(validatedBy = RentalStatusReturnedVehicleValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RentalStatusReturnedVehicle {

    String message() default RETURN_VEHICLE_RENTAL_STATUS;
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};

}
