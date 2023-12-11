package com.example.oop2.Models;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for managing the list of tickets.
 * Upon initialization, fills the list with data from tickets.csv
 */
public class TicketList {
    /**
     * The global ticket list
     */
    private static final List<Ticket> ticketList = new ArrayList<>();

    // Initialization method
    static {
        try {
            // The filepath to the list of tickets.
            String filePath = "src\\main\\resources\\com\\example\\oop2\\Data\\tickets.csv";

            // Tries to read the file at the specified path
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.US_ASCII))) {
                // Gets next line as string,
                // first readLine skips the file header.
                br.readLine();
                String line = br.readLine();

                // Executes if line is not null AND is not empty/whitespace
                while (line != null) {
                    if (!line.trim().isEmpty()) {
                        try {
                            // Splits the line into a ticket's id, client, purchase date, and showtime
                            // and adds it to the ticket list.
                            String[] attributes = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                            // Get ticket ID
                            int ticketID = Integer.parseInt(attributes[0]);

                            // Get client ID
                            int clientID = Integer.parseInt(attributes[1]);

                            // Get ticket purchase DateTime
                            LocalDateTime purchaseDateTime = LocalDateTime.parse(attributes[2]);

                            // Get showtime
                            Showtime ticketShowtime = null;
                            for (Showtime showtime : ShowtimeList.getShowtimeList()) {
                                if (showtime.getID() == Integer.parseInt(attributes[3])) {
                                    ticketShowtime = showtime;
                                    break;
                                }
                            }

                            Ticket ticket = new Ticket(ticketID, clientID, purchaseDateTime, ticketShowtime);
                            addTicket(ticket);
                        } catch (Exception ignored) { }
                    }
                    line = br.readLine();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating TicketList instance");
        }
    }

    /**
     * TicketList constructor, empty and private to prevent initialization
     */
    private TicketList() {
    }

    /**
     * Gets the global ticket list
     *
     * @return the global ticket list
     */
    public static List<Ticket> getTicketList() {
        return ticketList;
    }

    /**
     * Adds a ticket to the global ticket list.
     *
     * @param pTicket The ticket to be added.
     */
    public static void addTicket(Ticket pTicket) {
        ticketList.add(pTicket);
        saveTicketList();
    }

    /**
     * Updates a ticket on the global ticket list.
     *
     * @param index   Index of the ticket to be updated
     * @param pTicket The ticket with the changes made
     * @return true if the index is within the List's bounds, false if else.
     */
    public static boolean updateTicket(int index, Ticket pTicket) {
        // Checks if specified ticket is in the list range.
        if (index >= 0 && index <= ticketList.size() - 1) {
            ticketList.set(index, pTicket);
            saveTicketList();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes a ticket from the global ticket list.
     *
     * @param pTicket The ticket to be removed
     */
    public static void removeTicket(Ticket pTicket) {
        ticketList.remove(pTicket);
        saveTicketList();
    }

    /**
     * Saves the list of tickets to tickets.csv
     */
    public static void saveTicketList() {
        String filePath = "src\\main\\resources\\com\\example\\oop2\\Data\\tickets.csv";
        String header = "TicketID,ClientID,PurchaseDateTime,ShowtimeID";
        DataHelper.saveData(filePath, header, getTicketList());
    }
}
