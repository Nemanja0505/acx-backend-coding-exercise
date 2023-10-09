package com.accelex.sample.exercise.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Where(clause = "deleted = false")
public class Customer extends AbstractModel{

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private LocalDate birthDate;

    @Column(unique = true, nullable = false)
    private String driverLicenseNumber;

    @OneToMany(mappedBy = "customer")
    private Set<Rental> rentals = new HashSet<>();
}
