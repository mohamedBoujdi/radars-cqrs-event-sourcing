package com.boujdi.radarservice.queries.controllers;

import com.boujdi.dtos.radar.EventDataResponseDTO;
import com.boujdi.dtos.radar.OverSpeedDTO;
import com.boujdi.dtos.radar.RadarDTO;
import com.boujdi.queries.OverSpeedQuery;
import com.boujdi.queries.RadarQuery;
import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@CrossOrigin("*")
@RequestMapping("/query")
@AllArgsConstructor
public class RadarQueryController {

    private QueryGateway gateway;

    @GetMapping
    public CompletableFuture<List<RadarDTO>> getRadarList() {
        return gateway.query(new RadarQuery.GetAll(), ResponseTypes.multipleInstancesOf(RadarDTO.class));
    }

    @GetMapping("/{id}")
    public CompletableFuture<RadarDTO> getRadarById(@PathVariable String id) {
        return gateway.query(new RadarQuery.GetById(id), ResponseTypes.instanceOf(RadarDTO.class));
    }

    @GetMapping("/overspeeds/")
    public CompletableFuture<List<OverSpeedDTO>> getOverSpeeds() {
        return gateway.query(new OverSpeedQuery.GetAll(), ResponseTypes.multipleInstancesOf(OverSpeedDTO.class));
    }

    @GetMapping("/overspeeds/bymatriculation/{matriculation}")
    public CompletableFuture<List<OverSpeedDTO>> getOverSpeedsByVehicleMatriculation(@PathVariable String matriculation) {
        return gateway.query(new OverSpeedQuery.GetByVehicleMatriculation(matriculation), ResponseTypes.multipleInstancesOf(OverSpeedDTO.class));
    }

    @GetMapping(value = "/overspeeds/watch", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<OverSpeedDTO> watchOverSpeeds(){
        SubscriptionQueryResult<List<OverSpeedDTO>, OverSpeedDTO> queryResult = gateway.subscriptionQuery(
                new OverSpeedQuery.Watch(),
                ResponseTypes.multipleInstancesOf(OverSpeedDTO.class),
                ResponseTypes.instanceOf(OverSpeedDTO.class)
        );
        return queryResult.initialResult().flatMapMany(Flux::fromIterable).concatWith(queryResult.updates());
    }

    @GetMapping(value = "/subscribe", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<EventDataResponseDTO> subscribe(){
        SubscriptionQueryResult<List<EventDataResponseDTO>, EventDataResponseDTO> queryResult = gateway.subscriptionQuery(
                new OverSpeedQuery.WatchSubscribe(),
                ResponseTypes.multipleInstancesOf(EventDataResponseDTO.class),
                ResponseTypes.instanceOf(EventDataResponseDTO.class)
        );
        return queryResult.initialResult().flatMapMany(Flux::fromIterable).concatWith(queryResult.updates());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception){
        return new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
