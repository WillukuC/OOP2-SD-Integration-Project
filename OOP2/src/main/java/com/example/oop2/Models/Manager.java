package com.example.oop2.Models;

import java.time.LocalDateTime;

/**
 * Manager class for the Movie Theatre application.
 * Has more permissions than Client (can CRUD movies, showtimes and screening rooms)
 */
public class Manager extends User {
    public Manager(int pID, String pUsername, String pEmail, LocalDateTime pDateTimeJoined, String pPassword) {
        super(pID, pUsername, pEmail, pDateTimeJoined, pPassword, true);
    }
}
