package service;

import models.ParkingTicket;
import models.VehicleEnum;

import java.time.Instant;
import java.util.Date;
import java.util.Random;

public class EntranceGate {
    private int id;

    public ParkingTicket getTicket() {
        Random random = new Random(1000);
        return new ParkingTicket(random.nextInt(), Instant.now(), VehicleEnum.CAR);
    }
}
