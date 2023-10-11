package service;

import exception.ParkingFullException;
import models.ParkingTicket;
import models.VehicleEnum;
import repository.ParkingSpotRepository;
import repository.TicketRepository;

import java.time.Instant;
import java.util.Random;

public class EntranceGate {
    private int id;

    public EntranceGate() {
        this.id = 1996;
    }

    public ParkingTicket getTicket(VehicleEnum vehicle) {
        if (ParkingSpotRepository.vacantSpots.get(vehicle) > 0)
         {
             Random random = new Random(10);
             ParkingSpotRepository.vacantSpots.put(vehicle,
                     ParkingSpotRepository.vacantSpots.getOrDefault(vehicle, 0) + 1);

             ParkingTicket parkingTicket = new ParkingTicket(Math.abs(random.nextInt()), Instant.now(), vehicle);
             TicketRepository.activeTickets.put(parkingTicket.getId(), parkingTicket);
             TicketRepository.historyTickets.put(parkingTicket.getId(), parkingTicket);

             return parkingTicket;
         }
        else {
            System.out.println("Parking is full, Thank you!!");
            throw new ParkingFullException("Parking full for vehicle" + vehicle);
        }
    }
}
