package com.example.oop2.Models;

import java.time.LocalDateTime;

public class Ticket {
    private int aTicketId;
    private LocalDateTime aPurchaseDateTime;
    private Showtime aShowtime;

    public Ticket(int aTicketId, LocalDateTime aPurchaseDateTime, Showtime aShowtime) {
        this.aTicketId = aTicketId;
        this.aPurchaseDateTime = aPurchaseDateTime;
        this.aShowtime = aShowtime;
    }

    public void setTicketId(int aTicketId) {
        this.aTicketId = aTicketId;
    }

    public void setPurchaseDateTime(LocalDateTime aPurchaseDateTime) {
        this.aPurchaseDateTime = aPurchaseDateTime;
    }

    public void setShowtime(Showtime aShowtime) {
        this.aShowtime = aShowtime;
    }

    public int getTicketId() {
        return aTicketId;
    }

    public LocalDateTime getPurchaseDateTime() {
        return aPurchaseDateTime;
    }

    public Showtime getShowtime() {
        return aShowtime;
    }
}
