package service;

import models.ParkingTicket;
import models.PaymentStatusEnum;

import java.time.Instant;
import java.util.Date;

public class FixedRate implements PaymentStrategy{

    private final double rate = 2.0;
    @Override
    public ParkingTicket makePayment(ParkingTicket parkingTicket) {

        Instant start = parkingTicket.getEntranceTime();
        Instant end = Instant.now();

        double amount = ((end.toEpochMilli() - start.toEpochMilli()) / 1000.0) * rate;
        System.out.println("Total amount to be paid " + amount);
        parkingTicket.setAmount(amount);

//        assuming payment is done
        parkingTicket.setPaymentStatus(PaymentStatusEnum.PAID);
        System.out.println("Payment Success");
        return parkingTicket;
    }


}
