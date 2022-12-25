package com.boujdi.immatriculationservice.queries.services;

import com.boujdi.dtos.radar.OwnerDTO;
import com.boujdi.dtos.radar.VehicleDTO;
import com.boujdi.immatriculationservice.queries.mappers.OwnerMapper;
import com.boujdi.immatriculationservice.queries.mappers.VehicleMapper;
import com.boujdi.immatriculationservice.queries.repositories.OwnerRepository;
import com.boujdi.immatriculationservice.queries.repositories.VehicleRepository;
import com.boujdi.queries.MatriculationQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MatriculationQueryService {

    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private VehicleMapper vehicleMapper;
    @Autowired
    private OwnerMapper ownerMapper;

    @QueryHandler
    public List<VehicleDTO> getVehicleList(MatriculationQuery.GetAllVehicles query) {
        return vehicleRepository.findAll().stream().map(vehicle -> vehicleMapper.vehicleToVehicleDTO(vehicle)).collect(Collectors.toList());
    }

    @QueryHandler
    public List<OwnerDTO> getOwnerList(MatriculationQuery.GetAllOwners query) {
        return ownerRepository.findAll().stream().map(owner -> ownerMapper.ownerToOwnerDTO(owner)).collect(Collectors.toList());
    }
}
