package com.boujdi.immatriculationservice.queries.repositories;

import com.boujdi.immatriculationservice.queries.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
}
