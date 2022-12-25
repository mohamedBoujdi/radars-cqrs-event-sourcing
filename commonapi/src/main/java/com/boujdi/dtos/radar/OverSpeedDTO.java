package com.boujdi.dtos.radar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OverSpeedDTO {
    private String id;
    private Instant timeStamp;
    private String vehicleMatriculation;
    private int speed;
}
