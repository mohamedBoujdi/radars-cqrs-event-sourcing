package com.boujdi.radarservice.commands.controller;

import com.boujdi.exceptions.RequestException;
import com.boujdi.queries.RadarQuery;
import com.boujdi.radarservice.commands.services.*;
import lombok.AllArgsConstructor;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@CrossOrigin("*")
@RequestMapping("/command")
@AllArgsConstructor
public class RadarCommandController {
    private RadarCommandService radarService;

    @PostMapping
    public CompletableFuture<String> createRadar(@RequestBody RadarQuery.CreateRadar query) {
        return this.radarService.createRadar(query);
    }

    @PutMapping
    public CompletableFuture<String> updateRadar(@RequestBody RadarQuery.UpdateRadar query) {
        return this.radarService.updateRadar(query);
    }

    @PutMapping("/status")
    public CompletableFuture<String> updateRadarStatus(@RequestBody RadarQuery.UpdateRadarStatus query) {
        return this.radarService.updateRadarStatus(query);
    }

    @DeleteMapping
    public CompletableFuture<String> deleteRadar(@RequestBody RadarQuery.DeleteRadar query) {
        return this.radarService.deleteRadar(query);
    }

    @PostMapping("/overSpeed")
    public CompletableFuture<String> newOverSpeed(@RequestBody RadarQuery.OverSpeedDetected query){
        return this.radarService.overSpeed(query);
    }

    @ExceptionHandler(payloadType = RequestException.class)
    public ResponseEntity<String> requestExceptionHandler(RequestException exception){
        return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(payloadType = Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception){
        return new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
