package models;

import service.EntranceGate;
import service.ExitGate;

public class ParkingLot {
    private int id;
    private String name;

    private EntranceGate entranceGate;
    private ExitGate exitGate;

    private static volatile ParkingLot parkingLot = null;

    private ParkingLot() {

    }

    /**
     * this method return only instance of parking lot.
     * @return
     */
    public static ParkingLot getInstance() {
        if(parkingLot == null) {
            synchronized (ParkingLot.class) {
                if(parkingLot == null) {
                    parkingLot = new ParkingLot();
                }
            }
        }
        return parkingLot;
    }

}
