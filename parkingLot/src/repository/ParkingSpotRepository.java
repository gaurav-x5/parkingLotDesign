package repository;

import models.VehicleEnum;

import java.util.HashMap;

public class ParkingSpotRepository {
    public static HashMap<VehicleEnum, Integer> vacantSpots = new HashMap<>();

    private ParkingSpotRepository() {
    }
}
