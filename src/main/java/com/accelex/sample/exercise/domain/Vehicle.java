package com.accelex.sample.exercise.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Where(clause = "deleted = false")
public class Vehicle extends AbstractModel{

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private int yearProduction;

    @Column(nullable = false)
    private String colour;

    @Column(unique = true,nullable = false)
    private String registration;

    @OneToMany(mappedBy = "vehicle")
    private Set<Rental> rentedVehicle = new HashSet<>();

}
