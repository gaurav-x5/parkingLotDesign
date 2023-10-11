package service;

import exception.InvalidTicket;
import models.ParkingTicket;
import models.PaymentStatusEnum;
import repository.ParkingSpotRepository;
import repository.TicketRepository;

public class ExitGate {
    private int id;

    private PaymentStrategy paymentStrategy;

    public ExitGate(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    public boolean processParkingTicket(int parkingTicketId) {
        ParkingTicket parkingTicket = TicketRepository.activeTickets.get(parkingTicketId);
        if(parkingTicket == null) {
            System.out.println("Not a valid Ticket");
            throw new InvalidTicket("Ticket is invalid with id " + parkingTicketId);
        }
        boolean status =  paymentStrategy.makePayment(parkingTicket).getPaymentStatus() == PaymentStatusEnum.PAID;
        if (status) {
            ParkingSpotRepository.vacantSpots.put(parkingTicket.getVehicleEnum(),
                    ParkingSpotRepository.vacantSpots.get(parkingTicket.getVehicleEnum()) -1);
            System.out.printf("Exit Success for Vehicle with ticketId " + parkingTicketId);
        }
        return status;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
}
