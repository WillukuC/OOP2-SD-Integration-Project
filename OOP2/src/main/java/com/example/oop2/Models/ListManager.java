package com.example.oop2.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for managing the various lists stored in the application.
 */
public class ListManager {
    /**
     * List of Screening Rooms
     */
    private static final List<ScreeningRoom> screeningRoomList = new ArrayList<>();
    /**
     * List of Showtimes
     */
    private static final List<Showtime> showtimeList = new ArrayList<>();
    /**
     * List of Tickets
     */
    private static final List<Ticket> ticketList = new ArrayList<>();
    /**
     * List of Users
     */
    private static final List<User> userList = new ArrayList<>();

    /**
     * Private constructor to prevent instantiation (utility class)
     */
    private ListManager() {
        // prevent instantiation
    }

    static {

    }
    //---------------   screeningRoomList methods   ---------------
    //---------------   Showtime list methods   ---------------
    //---------------   Ticket list methods   ---------------
    //---------------   User list methods   ---------------
}
