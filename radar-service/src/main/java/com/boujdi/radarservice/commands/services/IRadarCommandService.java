package com.boujdi.radarservice.commands.services;

import java.util.concurrent.CompletableFuture;

public interface IRadarCommandService {
    CompletableFuture<String> createRadar(CreateRadarRequest request);
    CompletableFuture<String> updateRadar(UpdateRadarRequest request);
    CompletableFuture<String> deleteRadar(DeleteRadarRequest request);
}
