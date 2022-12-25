package com.boujdi.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

public abstract class MatriculationEvent {
    @Getter @AllArgsConstructor @NoArgsConstructor
    private abstract static class BaseVehicleEvent {
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
    private abstract static class BaseOwnerEvent {
        private String id;
        private String name;
        private Date birthday;
        private String email;
    }

    /**
     * New vehicle created
     */
    @NoArgsConstructor
    public static class VehicleCreated extends BaseVehicleEvent {
        public VehicleCreated(String id, String owner, String matriculation, String mark, String model, int fiscalPower) {
            super(id, owner, matriculation, mark, model, fiscalPower);
        }
    }

    /**
     * New owner added
     */
    @NoArgsConstructor
    public static class OwnerAdded extends BaseOwnerEvent {
        public OwnerAdded(String id, String name, Date birthday, String email) {
            super(id, name, birthday, email);
        }
    }
}
