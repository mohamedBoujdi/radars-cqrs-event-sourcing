package com.boujdi.immatriculationservice.commands.aggregates;

import com.boujdi.commands.MatriculationCommand;
import com.boujdi.events.MatriculationEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@NoArgsConstructor // required by Axon
public class VehicleAggregate {

    @AggregateIdentifier
    private String id;
    private String owner;
    private String matriculation;
    private String mark;
    private String model;
    private int fiscalPower;

    @CommandHandler
    public VehicleAggregate(MatriculationCommand.CreateVehicle command) {
        AggregateLifecycle.apply(new MatriculationEvent.VehicleCreated(
                command.getId(),
                command.getOwner(),
                command.getMatriculation(),
                command.getMark(),
                command.getModel(),
                command.getFiscalPower()
        ));
    }

    @EventSourcingHandler
    public void onVehicleCreated(MatriculationEvent.VehicleCreated event) {
        this.id = event.getId();
        this.owner = event.getOwner();
        this.matriculation = event.getMatriculation();
        this.mark = event.getMark();
        this.model = event.getModel();
        this.fiscalPower = event.getFiscalPower();
    }
}
