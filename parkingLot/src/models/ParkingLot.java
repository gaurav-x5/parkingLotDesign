package models;

import repository.ParkingSpotRepository;
import service.EntranceGate;
import service.ExitGate;
import service.ParkingLotFactory;

public class ParkingLot {
    private int id;
    private String name;

    private EntranceGate entranceGate;
    private ExitGate exitGate;

    private static volatile ParkingLot parkingLot = null;

    public ParkingLot(int id, String name, EntranceGate entranceGate, ExitGate exitGate) {
        this.id = id;
        this.name = name;
        this.entranceGate = entranceGate;
        this.exitGate = exitGate;

        initParkingLotCapacity();
    }

    private void initParkingLotCapacity() {
        ParkingSpotRepository.vacantSpots.put(VehicleEnum.CAR, 100);
        ParkingSpotRepository.vacantSpots.put(VehicleEnum.TRUCK, 100);
        ParkingSpotRepository.vacantSpots.put(VehicleEnum.VAN, 100);
        ParkingSpotRepository.vacantSpots.put(VehicleEnum.MOTORCYCLE, 100);
    }

    /**
     * this method return only instance of parking lot.
     * @return
     */
    public static ParkingLot getInstance() {
        if(parkingLot == null) {
            synchronized (ParkingLot.class) {
                if(parkingLot == null) {
                    parkingLot = ParkingLotFactory.getParkingLotInstance();
                }
            }
        }
        return parkingLot;
    }

    public ParkingTicket entry(VehicleEnum vehicleEnum) {
        System.out.println("Entry Success, Ticket provided for vehicle "+ vehicleEnum);
        return entranceGate.getTicket(vehicleEnum);
    }

    public boolean exit(int parkingTicketId) {
        return exitGate.processParkingTicket(parkingTicketId);
    }

    public void displayAvailableParkingSlots() {
        //display ParkingSpotRepository

    }

}
