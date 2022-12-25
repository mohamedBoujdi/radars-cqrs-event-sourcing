package com.boujdi.events;

import com.boujdi.enums.RadarStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public abstract class RadarEvent {

    @Getter @AllArgsConstructor @NoArgsConstructor
    private static class BaseRadarEvent {
        private String id;
        private int maxSpeed;
        private double longitude;
        private double latitude;
        private RadarStatus status;
    }

    /**
     * Radar created event
     */
    @NoArgsConstructor
    public static class Created extends BaseRadarEvent {
        public Created(String id, int maxSpeed, double longitude, double latitude, RadarStatus status) {
            super(id, maxSpeed, longitude, latitude, status);
        }
    }

    /**
     * Radar updated event
     */
    @NoArgsConstructor
    public static class Updated extends BaseRadarEvent {
        public Updated(String id, int maxSpeed, double longitude, double latitude, RadarStatus status) {
            super(id, maxSpeed, longitude, latitude, status);
        }
    }

    /**
     * Update radar status
     */
    @Getter @AllArgsConstructor @NoArgsConstructor
    public static class StatusUpdated {
        private String id;
        private RadarStatus status;
    }

    /**
     * Radar deleted event
     */
    @Getter @AllArgsConstructor @NoArgsConstructor
    public static class Deleted {
        private String id;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OverSpeedDetected {
        private String radar;
        private String vehicleMatriculation;
        private int speed;
    }
}
