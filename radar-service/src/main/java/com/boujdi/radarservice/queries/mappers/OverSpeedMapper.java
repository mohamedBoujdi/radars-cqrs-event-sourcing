package com.boujdi.radarservice.queries.mappers;

import com.boujdi.dtos.radar.OverSpeedDTO;
import com.boujdi.radarservice.queries.entities.OverSpeed;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OverSpeedMapper {
    OverSpeedDTO overSpeedToOverSpeedDTO(OverSpeed overSpeed);
}
