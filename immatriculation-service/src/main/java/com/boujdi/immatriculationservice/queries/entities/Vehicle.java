package com.boujdi.immatriculationservice.queries.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    private String id;
    private String matriculation;
    private String mark;
    private String model;
    private int fiscalPower;

    @ManyToOne
    private Owner owner;
}
