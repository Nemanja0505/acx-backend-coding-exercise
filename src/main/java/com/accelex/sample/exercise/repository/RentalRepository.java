package com.accelex.sample.exercise.repository;

import com.accelex.sample.exercise.domain.Rental;
import com.accelex.sample.exercise.domain.RentalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {

    @Query("select case when count(r) > 0 then true else false end from Rental r where r.vehicle.id = :vehicleId and r.status = 0 and :startDate <= r.endDate and :endDate >= r.startDate")
    boolean alreadyExistSameRentalRequest(Long vehicleId, LocalDate startDate, LocalDate endDate);

    @Query("select case when count(r) > 0 then true else false end from Rental r where r.vehicle.id = :vehicleId and r.status = 1")
    boolean isVehicleAlreadyInUse(Long vehicleId);

    List<Rental> findAllByStatus(RentalStatus status);
}
