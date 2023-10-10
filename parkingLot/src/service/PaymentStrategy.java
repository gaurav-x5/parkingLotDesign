package service;

import models.ParkingTicket;

public interface PaymentStrategy {
    public ParkingTicket makePayment(ParkingTicket parkingTicket);
}
