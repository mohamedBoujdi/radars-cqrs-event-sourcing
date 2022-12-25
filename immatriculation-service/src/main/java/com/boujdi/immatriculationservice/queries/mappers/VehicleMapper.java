package com.boujdi.immatriculationservice.queries.mappers;

import com.boujdi.dtos.radar.VehicleDTO;
import com.boujdi.immatriculationservice.queries.entities.Vehicle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleMapper {
    VehicleDTO vehicleToVehicleDTO(Vehicle vehicle);
}
