package com.boujdi.radarservice.queries.services;

import com.boujdi.dtos.radar.EventDataResponseDTO;
import com.boujdi.dtos.radar.OverSpeedDTO;
import com.boujdi.queries.OverSpeedQuery;
import com.boujdi.radarservice.queries.entities.OverSpeed;
import com.boujdi.radarservice.queries.mappers.OverSpeedMapper;
import com.boujdi.radarservice.queries.repositories.OverSpeedRepository;
import jakarta.transaction.Transactional;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OverSpeedQueryService {

    @Autowired
    private OverSpeedRepository overSpeedRepository;
    @Autowired
    private OverSpeedMapper overSpeedMapper;

    @QueryHandler
    public List<OverSpeedDTO> getAllOverSpeeds(OverSpeedQuery.GetAll query) {
        List<OverSpeed> list = overSpeedRepository.findAll();
        return list.stream().map(overSpeed -> overSpeedMapper.overSpeedToOverSpeedDTO(overSpeed)).collect(Collectors.toList());
    }

    @QueryHandler
    public List<OverSpeedDTO> getOverSpeedsByVehicleMatriculation(OverSpeedQuery.GetByVehicleMatriculation query) {
        List<OverSpeed> list = overSpeedRepository.findByVehicleMatriculation(query.getMatriculation());
        return list.stream().map(overSpeed -> overSpeedMapper.overSpeedToOverSpeedDTO(overSpeed)).collect(Collectors.toList());
    }

    @QueryHandler
    public List<EventDataResponseDTO> handle(OverSpeedQuery.WatchSubscribe query) {
        return new ArrayList<>();
    }
}
