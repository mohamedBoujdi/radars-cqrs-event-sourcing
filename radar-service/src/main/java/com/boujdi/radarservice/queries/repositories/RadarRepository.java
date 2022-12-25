package com.boujdi.radarservice.queries.repositories;

import com.boujdi.radarservice.queries.entities.Radar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RadarRepository extends JpaRepository<Radar, String> {
}
