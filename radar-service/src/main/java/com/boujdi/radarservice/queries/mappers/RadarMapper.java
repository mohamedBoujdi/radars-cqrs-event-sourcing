package com.boujdi.radarservice.queries.mappers;

import com.boujdi.dtos.radar.RadarDTO;
import com.boujdi.radarservice.queries.entities.Radar;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RadarMapper {
    RadarDTO radarToRadarDTO(Radar radar);
}
