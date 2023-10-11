package service;

import models.ParkingLot;

public class ParkingLotFactory {

    public static ParkingLot getParkingLotInstance() {

        return new ParkingLot(12, "Pheonix",
                new EntranceGate(), new ExitGate(new FixedRate()));
    }
}
