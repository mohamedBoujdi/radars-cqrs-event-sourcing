package com.boujdi.queries;

import com.boujdi.enums.RadarStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public abstract class RadarQuery {
    @Getter @AllArgsConstructor @NoArgsConstructor
    private static class BaseRadarQuery {
        private String id;
        private int maxSpeed;
        private double longitude;
        private double latitude;
        private RadarStatus status;
    }

    /**
     * Create radar query
     */
    @NoArgsConstructor
    public static class CreateRadar extends BaseRadarQuery {
        public CreateRadar(int maxSpeed, double longitude, double latitude, RadarStatus status) {
            super(null, maxSpeed, longitude, latitude, status);
        }
    }

    /**
     * Update rada query given its id
     */
    @NoArgsConstructor
    public static class UpdateRadar extends BaseRadarQuery {
        public UpdateRadar(String id, int maxSpeed, double longitude, double latitude, RadarStatus status) {
            super(id, maxSpeed, longitude, latitude, status);
        }
    }

    /**
     * Toggle radar status (on, off)
     */
    @Getter @AllArgsConstructor @NoArgsConstructor
    public static class UpdateRadarStatus {
        private String id;
        private RadarStatus status;
    }

    /**
     * Delete radar by its id
     */
    @Getter @AllArgsConstructor @NoArgsConstructor
    public static class DeleteRadar {
        private String id;
    }

    /**
     * Query emitted when over speed detected
     */
    @Getter @AllArgsConstructor @NoArgsConstructor
    public static class OverSpeedDetected {
        private String radar;
        private String vehicleMatriculation;
        private int speed;
    }

    /**
     * Get all radars query
     */
    public static class GetAll {}

    /**
     * Get radar by given id
     */
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class GetById {
        private String id;
    }
}
