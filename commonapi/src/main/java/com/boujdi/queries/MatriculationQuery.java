package com.boujdi.queries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

public abstract class MatriculationQuery {
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    private static class BaseVehicleQuery {
        private String id;
        private String owner;
        private String matriculation;
        private String mark;
        private String model;
        private int fiscalPower;
    }

    @Getter @AllArgsConstructor @NoArgsConstructor
    private static class BaseOwnerQuery {
        private String id;
        private String name;
        private Date birthday;
        private String email;
    }

    /**
     * Create new vehicle
     */
    @NoArgsConstructor
    public static class CreateVehicle extends BaseVehicleQuery {
        public CreateVehicle(String owner, String matriculation, String mark, String model, int fiscalPower) {
            super(null, owner, matriculation, mark, model, fiscalPower);
        }
    }

    public static class GetAllVehicles {}

    /**
     * Add new owner
     */
    @NoArgsConstructor
    public static class NewOwner extends BaseOwnerQuery {
        public NewOwner(String name, Date birthday, String email) {
            super(null, name, birthday, email);
        }
    }

    public static class GetAllOwners {}
}
