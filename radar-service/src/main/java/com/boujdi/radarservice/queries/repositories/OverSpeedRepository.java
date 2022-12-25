package com.boujdi.radarservice.queries.repositories;

import com.boujdi.radarservice.queries.entities.OverSpeed;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OverSpeedRepository extends JpaRepository<OverSpeed, String> {
    List<OverSpeed> findByVehicleMatriculation(String matriculation);
}
