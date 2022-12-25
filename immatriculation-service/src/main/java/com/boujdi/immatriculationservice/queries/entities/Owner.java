package com.boujdi.immatriculationservice.queries.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Owner {
    @Id
    private String id;
    private String name;
    private Date birthday;
    private String email;

    @OneToMany(mappedBy = "owner")
    private List<Vehicle> vehicles;
}

