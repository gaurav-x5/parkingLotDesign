package service;

import models.ParkingTicket;
import models.PaymentStatusEnum;

public class ExitGate {
    private int id;

    private PaymentStrategy paymentStrategy;

    public ExitGate(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    public boolean processParkingTicket(ParkingTicket parkingTicket) {
        return paymentStrategy.makePayment(parkingTicket).getPaymentStatus() == PaymentStatusEnum.PAID;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
}
