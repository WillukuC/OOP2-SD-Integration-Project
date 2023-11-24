package com.example.oop2.Models;

/**
 * Manager class for the Movie Theatre application.
 * Has more permissions than Client (can CRUD movies, showtimes and screening rooms)
 */
public class Manager extends User {
    public Manager(String aUsername, String aPassword) {
        super(aUsername, aPassword, true);
    }
}
