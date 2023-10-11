import models.ParkingLot;
import models.ParkingTicket;
import models.VehicleEnum;
import service.EntranceGate;
import service.ExitGate;
import service.FixedRate;
import service.ParkingLotFactory;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ParkingLot parkingLot = ParkingLot.getInstance();
        ParkingTicket parkingTicket = parkingLot.entry(VehicleEnum.CAR);
        Thread.sleep(1000);
        parkingLot.exit(parkingTicket.getId());
    }
}