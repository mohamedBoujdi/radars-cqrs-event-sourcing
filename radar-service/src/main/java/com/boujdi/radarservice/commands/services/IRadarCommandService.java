package com.boujdi.radarservice.commands.services;

import com.boujdi.queries.RadarQuery;

import java.util.concurrent.CompletableFuture;

public interface IRadarCommandService {

    CompletableFuture<String> createRadar(RadarQuery.CreateRadar query);
    CompletableFuture<String> updateRadar(RadarQuery.UpdateRadar query);
    CompletableFuture<String> updateRadarStatus(RadarQuery.UpdateRadarStatus query);
    CompletableFuture<String> deleteRadar(RadarQuery.DeleteRadar query);
    CompletableFuture<String> overSpeed(RadarQuery.OverSpeedDetected query);
}
