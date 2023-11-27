package com.example.oop2.Models;

import java.time.LocalDateTime;

/**
 * Generic User class for the movie theatre application.
 */
public class User {
    private int aID;
    private String aUsername;
    private String aEmail;
    private LocalDateTime aDateTimeJoined;
    private String aPassword;
    private boolean aIsManager;
    public User(int pID, String pUsername, String pEmail, LocalDateTime pDateTimeJoined, String pPassword, boolean pIsManager) {
        this.setID(pID);
        this.setUsername(pUsername);
        this.setEmail(pEmail);
        this.setDateTimeJoined(pDateTimeJoined);
        this.setPassword(pPassword);
        this.setIsManager(pIsManager);
    }

    public int getID() {
        return aID;
    }

    public void setID(int pID) {
        this.aID = pID;
    }

    public String getUsername() {
        return aUsername;
    }

    public void setUsername(String pUsername) {
        this.aUsername = pUsername;
    }

    public String getEmail() {
        return aEmail;
    }

    public void setEmail(String pEmail) {
        this.aEmail = pEmail;
    }

    public LocalDateTime getDateTimeJoined() {
        return aDateTimeJoined;
    }

    public void setDateTimeJoined(LocalDateTime pDateTimeJoined) {
        this.aDateTimeJoined = pDateTimeJoined;
    }

    public String getPassword() {
        return aPassword;
    }

    public void setPassword(String pPassword) {
        this.aPassword = pPassword;
    }

    public boolean isIsManager() {
        return aIsManager;
    }

    public void setIsManager(boolean pIsManager) {
        this.aIsManager = pIsManager;
    }

    public String toString(){
        return this.aID + "," +
                this.aUsername + "," +
                this.aEmail + "," +
                this.aDateTimeJoined + "," +
                this.aPassword + "," +
                this.aIsManager;

    }
}
