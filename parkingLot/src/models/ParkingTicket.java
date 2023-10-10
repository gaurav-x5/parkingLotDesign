package models;

import java.time.Instant;
import java.util.Date;

public class ParkingTicket {
    private int id;
    private Instant entranceTime;
    private Instant exitTime;
    private Double amount;
    private VehicleEnum vehicleEnum;
    private PaymentStatusEnum paymentStatus;

    public ParkingTicket(int id, Instant entranceTime, VehicleEnum vehicleEnum) {
        this.id = id;
        this.entranceTime = entranceTime;
        this.vehicleEnum = vehicleEnum;
        this.paymentStatus = PaymentStatusEnum.UNPAID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Instant getEntranceTime() {
        return entranceTime;
    }

    public void setEntranceTime(Instant entranceTime) {
        this.entranceTime = entranceTime;
    }

    public Instant getExitTime() {
        return exitTime;
    }

    public void setExitTime(Instant exitTime) {
        this.exitTime = exitTime;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public VehicleEnum getVehicleEnum() {
        return vehicleEnum;
    }

    public void setVehicleEnum(VehicleEnum vehicleEnum) {
        this.vehicleEnum = vehicleEnum;
    }

    public void setPaymentStatus(PaymentStatusEnum paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentStatusEnum getPaymentStatus() {
        return paymentStatus;
    }
}
