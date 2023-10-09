package com.accelex.sample.exercise.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Field;
import java.time.LocalDate;

public class CompareDateValidator implements ConstraintValidator<CompareDate,Object> {

    private String beforeDate;
    private String afterDate;

    @Override
    public void initialize(CompareDate constraintAnnotation) {
        beforeDate = constraintAnnotation.before();
        afterDate = constraintAnnotation.after();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        try {
            Field beforeDateField = value.getClass().getDeclaredField(beforeDate);
            beforeDateField.setAccessible(true);
            Field afterDateFiled = value.getClass().getDeclaredField(afterDate);
            afterDateFiled.setAccessible(true);

            LocalDate before = (LocalDate) beforeDateField.get(value);
            LocalDate after = (LocalDate) afterDateFiled.get(value);

            return before == null && after == null || (before != null && before.isBefore(after));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
