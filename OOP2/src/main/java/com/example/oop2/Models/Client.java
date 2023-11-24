package com.example.oop2.Models;

import java.time.LocalDateTime;

/**
 * Client class for the movie theatre application.
 * Has fewer permissions than Manager.
 */
public class Client extends User {
    private int aClientID;
    private String aName;
    private String aEmailAddress;
    private LocalDateTime aSignUpDateTime;
    public Client(String pUsername, String pPassword, int pClientID, String pName, String pEmailAddress, LocalDateTime pSignUpDateTime) {
        super(pUsername, pPassword, false);
        this.aClientID = pClientID;
        this.aName = pName;
        this.aEmailAddress = pEmailAddress;
        this.aSignUpDateTime = pSignUpDateTime;
    }

    public int getClientID() {
        return aClientID;
    }

    public void setClientID(int pClientID) {
        this.aClientID = pClientID;
    }

    public String getName() {
        return aName;
    }

    public void setName(String pName) {
        this.aName = pName;
    }

    public String getEmailAddress() {
        return aEmailAddress;
    }

    public void setEmailAddress(String aEmailAddress) {
        this.aEmailAddress = aEmailAddress;
    }

    public LocalDateTime getSignUpDateTime() {
        return aSignUpDateTime;
    }

    public void setSignUpDateTime(LocalDateTime aSignUpDateTime) {
        this.aSignUpDateTime = aSignUpDateTime;
    }
}
