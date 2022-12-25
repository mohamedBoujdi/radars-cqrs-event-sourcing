package com.boujdi.radarservice.queries.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OverSpeed {
    @Id
    private String id;
    private Instant timeStamp;
    private String vehicleMatriculation;
    private int speed;

    @ManyToOne
    private Radar radar;
}

