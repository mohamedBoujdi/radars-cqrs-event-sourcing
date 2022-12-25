package com.boujdi.radarservice.queries.services;

import com.boujdi.dtos.radar.EventDataResponseDTO;
import com.boujdi.dtos.radar.OverSpeedDTO;
import com.boujdi.enums.RadarStatus;
import com.boujdi.events.RadarEvent;
import com.boujdi.queries.OverSpeedQuery;
import com.boujdi.radarservice.queries.entities.OverSpeed;
import com.boujdi.radarservice.queries.entities.Radar;
import com.boujdi.radarservice.queries.mappers.OverSpeedMapper;
import com.boujdi.radarservice.queries.repositories.OverSpeedRepository;
import com.boujdi.radarservice.queries.repositories.RadarRepository;
import jakarta.transaction.Transactional;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.Timestamp;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@Transactional
public class RadarEventHandlerService {

    @Autowired
    private RadarRepository radarRepository;
    @Autowired
    private OverSpeedRepository overSpeedRepository;
    @Autowired
    private OverSpeedMapper overSpeedMapper;
    @Autowired
    private QueryUpdateEmitter updateEmitter;

    @EventHandler
    public void onRadarCreated(RadarEvent.Created event) {
        Radar radar = Radar.builder()
                .id(event.getId())
                .maxSpeed(event.getMaxSpeed())
                .longitude(event.getLongitude())
                .latitude(event.getLatitude())
                .status(RadarStatus.ACTIVE)
                .build();
        radarRepository.save(radar);
    }

    @EventHandler
    public void onRadarUpdated(RadarEvent.Updated event) {
        Radar radar = radarRepository.findById(event.getId()).orElseThrow(() -> new RuntimeException("Radar not found"));
        if(event.getMaxSpeed() != 0) radar.setMaxSpeed(event.getMaxSpeed());
        if(event.getLongitude() != 0) radar.setLongitude(event.getLongitude());
        if(event.getLatitude() != 0) radar.setLatitude(event.getLatitude());
        radarRepository.save(radar);
    }

    @EventHandler
    public void onRadarStatusUpdated(RadarEvent.StatusUpdated event) {
        Radar radar = radarRepository.findById(event.getId()).orElseThrow(() -> new RuntimeException("Radar not found"));
        radar.setStatus(event.getStatus());
        radarRepository.save(radar);
    }

    @EventHandler
    public void onRadarDeleted(RadarEvent.Deleted event) {
        radarRepository.deleteById(event.getId());
    }

    @EventHandler
    public void onOverSpeedDetected(RadarEvent.OverSpeedDetected event, @Timestamp Instant timestamp) {
        Radar radar = radarRepository.findById(event.getRadar()).orElseThrow(() -> new RuntimeException("Radar not found"));
        OverSpeed overSpeed = OverSpeed.builder()
                .id(UUID.randomUUID().toString())
                .vehicleMatriculation(event.getVehicleMatriculation())
                .speed(event.getSpeed())
                .timeStamp(timestamp)
                .radar(radar)
                .build();

        //* save over speed
        overSpeed = overSpeedRepository.save(overSpeed);

        OverSpeedDTO overSpeedDTO = overSpeedMapper.overSpeedToOverSpeedDTO(overSpeed);
        EventDataResponseDTO eventDataResponseDTO = new EventDataResponseDTO(
                event.getClass().getSimpleName(),
                overSpeedDTO
        );

        //* dispatch event
        updateEmitter.emit(OverSpeedQuery.WatchSubscribe.class, (query) -> true, eventDataResponseDTO);
    }

}
