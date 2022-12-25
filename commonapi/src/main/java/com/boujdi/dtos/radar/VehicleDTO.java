package com.boujdi.dtos.radar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {
    private String id;
    private String matriculation;
    private String mark;
    private String model;
    private int fiscalPower;
}
