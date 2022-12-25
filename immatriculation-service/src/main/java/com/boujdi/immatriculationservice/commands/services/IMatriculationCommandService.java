package com.boujdi.immatriculationservice.commands.services;

import java.util.concurrent.CompletableFuture;

public interface IMatriculationCommandService {
    CompletableFuture<String> createVehicle(MatriculationQuery.CreateVehicle query);
    CompletableFuture<String> newOwner(MatriculationQuery.NewOwner query);
}
