package com.accelex.sample.exercise.dto;

import com.accelex.sample.exercise.domain.RentalStatus;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RentalDto {

    private Long id;
    private RentalRequestDto request;
    private RentalStatus status;

}
