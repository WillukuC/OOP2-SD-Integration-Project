package com.example.oop2.Models;

import java.time.LocalDateTime;

/**
 * Utility class for managing the list of tickets.
 * Upon initialization, fills the list with data from tickets.csv
 */
public class Ticket {
    /**
     * The ticket's ID
     */
    private int aTicketID;
    /**
     * The ID of the client who purchased the ticket
     */
    private int aClientID;
    /**
     * The date and time the ticket was purchased
     */
    private LocalDateTime aPurchaseDateTime;
    /**
     * The showtime that the ticket is for
     */
    private Showtime aShowtime;

    /**
     * The ticket constructor
     *
     * @param pTicketID The ID of the ticket
     * @param pClientID The ID of the client who bought the ticket
     * @param pPurchaseDateTime The date and time the ticket was purchased
     * @param pShowtime The showtime of the ticket
     */
    public Ticket(int pTicketID, int pClientID, LocalDateTime pPurchaseDateTime, Showtime pShowtime) {
        this.setTicketID(pTicketID);
        this.setClientID(pClientID);
        this.setPurchaseDateTime(pPurchaseDateTime);
        this.setShowtime(pShowtime);
    }

    /**
     * Get the Ticket's ID
     *
     * @return The ID of the ticket
     */
    public int getTicketID() {
        return aTicketID;
    }

    public void setTicketID(int pTicketId) {
        this.aTicketID = pTicketId;
    }

    /**
     * Get the ID of the client who purchased the ticket
     *
     * @return The ID of the client who bought the ticket
     */
    public int getClientID() {
        return this.aClientID;
    }

    public void setClientID(int pClientID) {
        this.aClientID = pClientID;
    }

    /**
     * Get the date and time the ticket was purchased
     *
     * @return The date and time of the purchase
     */
    public LocalDateTime getPurchaseDateTime() {
        return aPurchaseDateTime;
    }

    public void setPurchaseDateTime(LocalDateTime pPurchaseDateTime) {
        this.aPurchaseDateTime = pPurchaseDateTime;
    }

    /**
     * The showtime represented by the ticket
     *
     * @return The showtime of the ticket
     */
    public Showtime getShowtime() {
        return aShowtime;
    }

    public void setShowtime(Showtime pShowtime) {
        this.aShowtime = pShowtime;
    }

    /**
     * Returns the Ticket as a single String
     * The returned String is formtted as "TicketID,ClientID,PurchaseDateTime,ShowtimeID"
     *
     * @return The ticket as a single string
     */
    public String toString() {
        return this.aTicketID + "," +
                this.aClientID + "," +
                this.aPurchaseDateTime + "," +
                this.aShowtime.getID();
    }
}
