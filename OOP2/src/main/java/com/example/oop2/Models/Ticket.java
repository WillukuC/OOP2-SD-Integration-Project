package com.example.oop2.Models;

import java.time.LocalDateTime;

public class Ticket {
    private int aTicketID;
    private int aClientID;
    private LocalDateTime aPurchaseDateTime;
    private Showtime aShowtime;

    public Ticket(int pTicketID, int pClientID, LocalDateTime pPurchaseDateTime, Showtime pShowtime) {
        this.setTicketID(pTicketID);
        this.setClientID(pClientID);
        this.setPurchaseDateTime(pPurchaseDateTime);
        this.setShowtime(pShowtime);
    }

    public void setTicketID(int pTicketId) {
        this.aTicketID = pTicketId;
    }

    public int getTicketID() {
        return aTicketID;
    }

    public void setClientID(int pClientID) {
        this.aClientID = pClientID;
    }

    public int getClientID() {
        return this.aClientID;
    }

    public void setPurchaseDateTime(LocalDateTime pPurchaseDateTime) {
        this.aPurchaseDateTime = pPurchaseDateTime;
    }

    public LocalDateTime getPurchaseDateTime() {
        return aPurchaseDateTime;
    }

    public void setShowtime(Showtime pShowtime) {
        this.aShowtime = pShowtime;
    }

    public Showtime getShowtime() {
        return aShowtime;
    }

    public String toString() {
        return this.aTicketID + "," +
                this.aClientID + "," +
                this.aPurchaseDateTime + "," +
                this.aShowtime.getID();
    }
}
