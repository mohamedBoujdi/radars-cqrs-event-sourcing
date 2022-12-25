package com.boujdi.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

public abstract class MatriculationCommand {
    @Getter
    @AllArgsConstructor @NoArgsConstructor
    private static class BaseVehicleCommand {
        private String id;
        private String owner;
        private String matriculation;
        private String mark;
        private String model;
        private int fiscalPower;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    private static class BaseOwnerCommand {
        private String id;
        private String name;
        private Date birthday;
        private String email;
    }

    /**
     * Create new vehicle
     */
    @NoArgsConstructor
    public static class CreateVehicle extends BaseVehicleCommand {
        public CreateVehicle(String id, String owner, String matriculation, String mark, String model, int fiscalPower) {
            super(id, owner, matriculation, mark, model, fiscalPower);
        }
    }

    /**
     * Add new owner
     */
    @NoArgsConstructor
    public static class NewOwner extends BaseOwnerCommand {
        public NewOwner(String id, String name, Date birthday, String email) {
            super(id, name, birthday, email);
        }
    }
}
