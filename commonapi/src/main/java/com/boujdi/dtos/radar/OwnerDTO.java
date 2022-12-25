package com.boujdi.dtos.radar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerDTO {
    private String id;
    private String name;
    private Date birthday;
    private String email;
    private List<VehicleDTO> vehicles;
}

