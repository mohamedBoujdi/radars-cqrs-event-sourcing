package com.boujdi.radarservice.commands.aggregates;

import com.boujdi.commands.RadarCommand;
import com.boujdi.events.RadarEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@NoArgsConstructor // required by Axon
public class RadarAggregate {
    @AggregateIdentifier
    private String radarId;
    private int maxSpeed;
    private double longitude;
    private double latitude;

    @CommandHandler
    public RadarAggregate(RadarCommand.CreateRadar command) {
        AggregateLifecycle.apply(new RadarEvent.Created(
                command.getId(),
                command.getMaxSpeed(),
                command.getLongitude(),
                command.getLatitude(),
                command.getStatus()
        ));
    }

    @CommandHandler
    public void radarUpdateCmdHandler(RadarCommand.UpdateRadar command) {
        AggregateLifecycle.apply(new RadarEvent.Updated(
                command.getId(),
                command.getMaxSpeed(),
                command.getLongitude(),
                command.getLatitude(),
                command.getStatus()
        ));
    }

    @CommandHandler
    public void radarUpdateStatusCmdHandler(RadarCommand.UpdateRadarStatus command) {
        AggregateLifecycle.apply(new RadarEvent.StatusUpdated(
                command.getId(),
                command.getStatus()
        ));
    }

    @CommandHandler
    public void deleteRadarCmdHandler(RadarCommand.DeleteRadar command) {
        AggregateLifecycle.apply(new RadarEvent.Deleted(command.getId()));
    }

    @CommandHandler
    public void overSpeedCmdHandler(RadarCommand.OverSpeedDetected command) {
        AggregateLifecycle.apply(new RadarEvent.OverSpeedDetected(
                command.getRadar(),
                command.getVehicleMatriculation(),
                command.getSpeed()
        ));
    }

    @EventSourcingHandler
    public void onCreateRadar(RadarEvent.Created event) {
        this.radarId = event.getId();
        this.maxSpeed = event.getMaxSpeed();
        this.longitude = event.getLongitude();
        this.latitude = event.getLatitude();
    }

}
