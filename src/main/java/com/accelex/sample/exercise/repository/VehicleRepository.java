package com.accelex.sample.exercise.repository;

import com.accelex.sample.exercise.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("select v, r from Vehicle v left join fetch Rental r on v.id = r.vehicle.id where r.status = 1")
    List<Object[]> getCurrentRentedVehicles();

}
