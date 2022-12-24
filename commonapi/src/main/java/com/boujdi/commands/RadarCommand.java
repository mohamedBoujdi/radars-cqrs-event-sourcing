package com.boujdi.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;

public abstract class RadarCommand {
    @Getter @AllArgsConstructor
    private static class BaseRadarCommand {
        private String id;
        private int maxSpeed;
        private double longitude;
        private double latitude;
        private RadarStatus status;
    }

    /**
     * Create radar command
     */
    public static class CreateRadar extends BaseRadarCommand {
        public CreateRadar(String id, int maxSpeed, double longitude, double latitude, RadarStatus status) {
            super(id, maxSpeed, longitude, latitude, status);
        }
    }

    /**
     * Update radar command
     */
    public static class UpdateRadar extends BaseRadarCommand {
        public UpdateRadar(String id, int maxSpeed, double longitude, double latitude, RadarStatus status) {
            super(id, maxSpeed, longitude, latitude, status);
        }
    }

    /**
     * Toggle radar status (on, off)
     */
    @Getter @AllArgsConstructor
    public static class UpdateRadarStatus {
        private String id;
        private RadarStatus status;
    }

    /**
     * Delete radar command
     */
    @Getter @AllArgsConstructor
    public static class DeleteRadar {
        private String id;
    }

    /**
     * Command for over speed
     */
    @Getter @AllArgsConstructor
    public static class OverSpeedDetected {
        private String radar;
        private String vehicleMatriculation;
        private int speed;
    }

    /**
     * Get all radars command
     */
    public static class GetAll {}

    /**
     * Get radar by id
     */
    @Getter
    @AllArgsConstructor
    public static class GetById {
        private String id;
    }
}
