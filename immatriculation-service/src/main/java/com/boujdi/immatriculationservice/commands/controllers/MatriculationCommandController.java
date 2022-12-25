package com.boujdi.immatriculationservice.commands.controllers;

import com.boujdi.immatriculationservice.commands.services.MatriculationCommandService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@CrossOrigin("*")
@RequestMapping("/command")
@AllArgsConstructor
public class MatriculationCommandController {

    private MatriculationCommandService matriculationCommandService;

    @PostMapping("vehicle")
    public CompletableFuture<String> createVehicle(@RequestBody MatriculationQuery.CreateVehicle query) {
        return matriculationCommandService.createVehicle(query);
    }

    @PostMapping("owner")
    public CompletableFuture<String> newOwner(@RequestBody MatriculationQuery.NewOwner query) {
        return matriculationCommandService.newOwner(query);
    }
}
