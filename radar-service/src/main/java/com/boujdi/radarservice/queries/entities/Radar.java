package com.boujdi.radarservice.queries.entities;

import com.boujdi.enums.RadarStatus;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @Builder
@AllArgsConstructor @NoArgsConstructor
public class Radar {
    @Id
    private String id;
    private int maxSpeed;
    private double longitude;
    private double latitude;
    private RadarStatus status;

    @OneToMany(mappedBy = "radar")
    private List<OverSpeed> overSpeedList;
}
