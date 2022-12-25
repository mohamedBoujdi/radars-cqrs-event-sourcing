package com.boujdi.immatriculationservice.queries.controllers;

import com.boujdi.dtos.radar.OwnerDTO;
import com.boujdi.dtos.radar.VehicleDTO;
import com.boujdi.queries.MatriculationQuery;
import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@CrossOrigin("*")
@RequestMapping("/query")
@AllArgsConstructor
public class MatriculationQueryController {

    private QueryGateway gateway;

    @GetMapping("/vehicles")
    public CompletableFuture<List<VehicleDTO>> getVehicleList() {
        return gateway.query(new MatriculationQuery.GetAllVehicles(), ResponseTypes.multipleInstancesOf(VehicleDTO.class));
    }

    @GetMapping("/owners")
    public CompletableFuture<List<OwnerDTO>> getOwnerList() {
        return gateway.query(new MatriculationQuery.GetAllOwners(), ResponseTypes.multipleInstancesOf(OwnerDTO.class));
    }
}
