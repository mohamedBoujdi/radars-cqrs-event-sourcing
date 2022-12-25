package com.boujdi.queries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public abstract class OverSpeedQuery {
    private static class BaseOverSpeedQuery {

    }

    public static class GetAll {}

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class GetByVehicleMatriculation {
        private String matriculation;
    }

    public static class Watch {}

    public static class WatchSubscribe {}
}
