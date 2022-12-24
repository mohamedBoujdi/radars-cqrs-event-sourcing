package com.boujdi.radarservice.commands.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
@RequestMapping("/command")
public class RadarCommandController {

    @PostMapping
    public CompletableFuture<String> createRadar(@RequestBody CreateRadarRequest request) {
        return this.radarService.createRadar(request);
    }


}
