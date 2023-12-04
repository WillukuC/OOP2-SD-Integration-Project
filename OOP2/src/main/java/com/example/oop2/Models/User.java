package com.example.oop2.Models;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Generic User class for the movie theatre application.
 */
public class User {
    /**
     *  The user's ID
     */
    private int aID;
    /**
     * The user's username
     */
    private String aUsername;
    /**
     * The user's email
     */
    private String aEmail;
    /**
     * The date and time the user created their account
     */
    private LocalDateTime aDateTimeJoined;
    /**
     * The user's password
     */
    private String aPassword;
    /**
     * Whether the user is a manager or not
     * True if yes, false if no
     */
    private boolean aIsManager;

    /**
     * The user constructor
     *
     * @param pID The user's ID
     * @param pUsername The user's username
     * @param pEmail The user's email
     * @param pDateTimeJoined The date and time the user joined
     * @param pPassword The user's password
     * @param pIsManager The user's manager status
     */
    public User(int pID, String pUsername, String pEmail, LocalDateTime pDateTimeJoined, String pPassword, boolean pIsManager) {
        this.setID(pID);
        this.setUsername(pUsername);
        this.setEmail(pEmail);
        this.setDateTimeJoined(pDateTimeJoined);
        this.setPassword(pPassword);
        this.setIsManager(pIsManager);
    }

    /**
     * Get the user's ID
     *
     * @return The ID of the user
     */
    public int getID() {
        return aID;
    }

    /**
     * Set the user's ID
     *
     * @param pID The user's new ID
     */
    public void setID(int pID) {
        if (pID >= 0) {
            this.aID = pID;
        } else {
            throw new IllegalArgumentException("Invalid ID. Please provide an ID greater than or equal to 0.");
        }
    }

    /**
     * Get the user's username
     *
     * @return The username of the user
     */
    public String getUsername() {
        return aUsername;
    }

    /**
     * Set the user's username
     *
     * @param pUsername The user's new username
     */
    public void setUsername(String pUsername) {
        if (pUsername != null && !pUsername.trim().isEmpty()) {
            this.aUsername = pUsername;
        } else {
            throw new IllegalArgumentException("Invalid username. Please provide a non-empty username.");
        }
    }

    /**
     * Get the user's email address
     *
     * @return The email address of the user
     */
    public String getEmail() {
        return aEmail;
    }

    /**
     * Set the user's email address
     *
     * @param pEmail The user's new email address
     */
    public void setEmail(String pEmail) {
        if (pEmail.contains("@") && pEmail.contains(".")) {
            this.aEmail = pEmail;
        } else {
            throw new IllegalArgumentException("Invalid email. Please provide an email that is formatted as such:\nuser@email.com");
        }
    }

    /**
     * Get the date and time the user created their account
     *
     * @return The date and time when the user created their account
     */
    public LocalDateTime getDateTimeJoined() {
        return aDateTimeJoined;
    }

    /**
     * Set the date and time the user created their account
     *
     * @param pDateTimeJoined The user's new join date and time
     */
    public void setDateTimeJoined(LocalDateTime pDateTimeJoined) {
        if (pDateTimeJoined.isBefore(LocalDateTime.now()) || pDateTimeJoined.isEqual(LocalDateTime.now())) {
            this.aDateTimeJoined = pDateTimeJoined;
        } else {
            throw new IllegalArgumentException("Invalid date. Please provide a date that is before or equal to the current date.");
        }
    }

    /**
     * Get the user's password
     *
     * @return The password of the user
     */
    public String getPassword() {
        return aPassword;
    }

    /**
     * Set the user's password
     *
     * @param pPassword The user's new password
     */
    public void setPassword(String pPassword) {
        if (pPassword.length() <= 8) {
            this.aPassword = pPassword;
        } else {
            throw new IllegalArgumentException("Invalid password. Please provide a password that is greater than or equal to 8 characters.");
        }
    }

    /**
     * The user's manager status
     *
     * @return True if Manager, False if Client
     */
    public boolean isManager() {
        return aIsManager;
    }

    /**
     * Sets the user's manager status
     *
     * @param pIsManager True if Manager, False if Client
     */
    public void setIsManager(boolean pIsManager) {
        this.aIsManager = pIsManager;
    }

    /**
     * Returns the User as a single String
     * The returned String is formatted as:
     * "UserID,Username,Email,DateTimeJoined,Password,IsManager"
     *
     * @return the User as a String
     */
    public String toString() {
        return this.aID + "," +
                this.aUsername + "," +
                this.aEmail + "," +
                this.aDateTimeJoined + "," +
                this.aPassword + "," +
                this.aIsManager;
    }

    /**
     * Verifies if a given String matches the user password
     *
     * @param pPassword The password input by the user
     * @return          True if the password is correct, false if not
     */
    public boolean isCorrectPassword(String pPassword) {
        return Objects.equals(pPassword, aPassword);
    }
}
