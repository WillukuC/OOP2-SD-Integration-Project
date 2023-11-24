package com.example.oop2.Models;

/**
 * Generic User class for the movie theatre application.
 */
public class User {
    private String aUsername;
    private String aPassword;
    private boolean isManager;

    public User(String pUsername, String pPassword, boolean pIsManager) {
        this.aUsername = pUsername;
        this.aPassword = pPassword;
        this.isManager = pIsManager;
    }

    public String getUsername() {
        return aUsername;
    }

    public void setUsername(String pUsername) {
        this.aUsername = pUsername;
    }

    public String getPassword() {
        return aPassword;
    }

    public void setPassword(String pPassword) {
        this.aPassword = pPassword;
    }
}
