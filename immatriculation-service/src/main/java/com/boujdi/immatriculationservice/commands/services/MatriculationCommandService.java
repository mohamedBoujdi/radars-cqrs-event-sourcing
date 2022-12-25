package com.boujdi.immatriculationservice.commands.services;

import com.boujdi.commands.MatriculationCommand;
import com.boujdi.queries.MatriculationQuery;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class MatriculationCommandService implements IMatriculationCommandService {

    @Autowired
    private CommandGateway gateway;

    @Override
    public CompletableFuture<String> createVehicle(MatriculationQuery.CreateVehicle query) {
        return gateway.send(new MatriculationCommand.CreateVehicle(
                UUID.randomUUID().toString(),
                query.getOwner(),
                query.getMatriculation(),
                query.getMark(),
                query.getModel(),
                query.getFiscalPower()
        ));
    }

    @Override
    public CompletableFuture<String> newOwner(MatriculationQuery.NewOwner query) {
        return gateway.send(new MatriculationCommand.NewOwner(
                UUID.randomUUID().toString(),
                query.getName(),
                query.getBirthday(),
                query.getEmail()
        ));
    }
}


