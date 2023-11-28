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

    /**
     * Sets the ticket ID
     *
     * @param pTicketId The new ID of the ticket
     */
    public void setTicketID(int pTicketId) {
        if (pTicketId >= 0) {
            this.aTicketID = pTicketId;
        } else {
            throw new IllegalArgumentException("Invalid ID. Please provide an ID greater than or equal to 0.");
        }
    }

    /**
     * Get the ID of the client who purchased the ticket
     *
     * @return The ID of the client who bought the ticket
     */
    public int getClientID() {
        return this.aClientID;
    }

    /**
     * Sets the ID of the client who purchased the ticket
     *
     * @param pClientID The new ID of the client who bought the ticket
     */
    public void setClientID(int pClientID) {
        if (pClientID >= 0) {
            this.aClientID = pClientID;
        } else {
            throw new IllegalArgumentException("Invalid ID. Please provide an ID greater than or equal to 0.");
        }
    }

    /**
     * Get the date and time the ticket was purchased
     *
     * @return The date and time of the purchase
     */
    public LocalDateTime getPurchaseDateTime() {
        return aPurchaseDateTime;
    }

    /**
     * Set the date and time the ticket was purchased
     *
     * @param pPurchaseDateTime The date and time of the purchase
     */
    public void setPurchaseDateTime(LocalDateTime pPurchaseDateTime) {
        if (pPurchaseDateTime.isBefore(LocalDateTime.now()) || pPurchaseDateTime.isEqual(LocalDateTime.now())) {
            this.aPurchaseDateTime = pPurchaseDateTime;
        } else {
            throw new IllegalArgumentException("Invalid date. Please provide a date that is before or equal to the current date.");
        }
    }

    /**
     * The showtime represented by the ticket
     *
     * @return The showtime of the ticket
     */
    public Showtime getShowtime() {
        return aShowtime;
    }

    /**
     * Sets the showtime represented by the ticket
     *
     * @param pShowtime The new showtime of the ticket
     */
    public void setShowtime(Showtime pShowtime) {
        if (pShowtime != null && ShowtimeList.getShowtimeList().contains(pShowtime)) {
            this.aShowtime = pShowtime;
        } else {
            throw new IllegalArgumentException("Invalid Showtime. Please provide a valid showtime.");
        }
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
