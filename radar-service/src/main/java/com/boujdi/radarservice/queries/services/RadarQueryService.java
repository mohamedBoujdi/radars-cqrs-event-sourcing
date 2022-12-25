package com.boujdi.radarservice.queries.services;

import com.boujdi.dtos.radar.RadarDTO;
import com.boujdi.queries.RadarQuery;
import com.boujdi.radarservice.queries.entities.Radar;
import com.boujdi.radarservice.queries.mappers.RadarMapper;
import com.boujdi.radarservice.queries.repositories.RadarRepository;
import jakarta.transaction.Transactional;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RadarQueryService {
    @Autowired
    private RadarRepository radarRepository;
    @Autowired
    private RadarMapper radarMapper;

    @QueryHandler
    public List<RadarDTO> getAllRadars(RadarQuery.GetAll query) {
        return radarRepository.findAll().stream().map(radar -> radarMapper.radarToRadarDTO(radar)).collect(Collectors.toList());
    }

    @QueryHandler
    public RadarDTO getRadarById(RadarQuery.GetById query) {
        Radar radar = radarRepository.findById(query.getId()).get();
        return radarMapper.radarToRadarDTO(radar);
    }
}
