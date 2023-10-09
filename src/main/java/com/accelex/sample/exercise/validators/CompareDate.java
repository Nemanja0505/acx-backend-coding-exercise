package com.accelex.sample.exercise.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CompareDateValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CompareDate {

    String message() ;
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};
    String before();
    String after();

}
