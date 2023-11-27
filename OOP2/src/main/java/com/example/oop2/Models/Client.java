package com.example.oop2.Models;

import java.time.LocalDateTime;

/**
 * Client class for the movie theatre application.
 * Has fewer permissions than Manager.
 */
public class Client extends User {
    public Client(int pID, String pUsername, String pEmail, LocalDateTime pDateTimeJoined, String pPassword) {
        super(pID, pUsername, pEmail, pDateTimeJoined, pPassword, false);
    }
}
