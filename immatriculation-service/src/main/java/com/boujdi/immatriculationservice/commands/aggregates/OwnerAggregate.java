package com.boujdi.immatriculationservice.commands.aggregates;

import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Date;

@Aggregate
@NoArgsConstructor // required by Axon
public class OwnerAggregate {

    @AggregateIdentifier
    private String id;
    private String name;
    private Date birthday;
    private String email;

    @CommandHandler
    public OwnerAggregate(MatriculationCommand.NewOwner command) {
        AggregateLifecycle.apply(new MatriculationEvent.OwnerAdded(
                command.getId(),
                command.getName(),
                command.getBirthday(),
                command.getEmail()
        ));
    }

    @EventSourcingHandler
    public void onVehicleCreated(MatriculationEvent.OwnerAdded event) {
        this.id = event.getId();
        this.name = event.getName();
        this.birthday = event.getBirthday();
        this.email = event.getEmail();
    }
}
