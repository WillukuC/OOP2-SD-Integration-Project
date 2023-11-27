package com.example.oop2.Models;

import java.time.LocalDateTime;

public class Ticket {
    private int aTicketId;
    private LocalDateTime aPurchaseDateTime;
    private Showtime aShowtime;

    public Ticket(int pTicketId, LocalDateTime pPurchaseDateTime, Showtime pShowtime) {
        this.setTicketId(pTicketId);
        this.setPurchaseDateTime(pPurchaseDateTime);
        this.setShowtime(pShowtime);
    }

    public void setTicketId(int pTicketId) {
        this.aTicketId = pTicketId;
    }

    public int getTicketId() {
        return aTicketId;
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
}
