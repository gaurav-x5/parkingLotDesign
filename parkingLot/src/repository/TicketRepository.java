package repository;

import models.ParkingTicket;

import java.util.HashMap;

public class TicketRepository {
    public static HashMap<Integer, ParkingTicket> activeTickets;
    public static HashMap<Integer, ParkingTicket> historyTickets;

    private TicketRepository() {
    }
}
