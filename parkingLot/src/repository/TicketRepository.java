package repository;

import models.ParkingTicket;

import java.util.HashMap;

public class TicketRepository {
    public static HashMap<Integer, ParkingTicket> activeTickets = new HashMap<>();
    public static HashMap<Integer, ParkingTicket> historyTickets = new HashMap<>();

    private TicketRepository() {
    }
}
