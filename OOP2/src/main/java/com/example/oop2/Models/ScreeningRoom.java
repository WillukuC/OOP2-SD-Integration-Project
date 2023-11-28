package com.example.oop2.Models;

/**
 * Class for storing a screening room's information
 */
public class ScreeningRoom {
    /**
     * The room's number
     */
    private int aRoomNumber;

    /**
     * The constructor of a screening room
     *
     * @param pRoomNumber The room's number
     */
    public ScreeningRoom(int pRoomNumber) {
        this.setRoomNumber(pRoomNumber);
    }

    /**
     * Returns the screening room number
     *
     * @return The number of the room
     */
    public int getRoomNumber() {
        return aRoomNumber;
    }

    /**
     * Sets the number of the screening room
     *
     * @param pRoomNumber the room's new number
     */
    public void setRoomNumber(int pRoomNumber) {
        if (pRoomNumber > 0) {
            this.aRoomNumber = pRoomNumber;
        } else {
            throw new IllegalArgumentException("Invalid room number. Please provide a room number higher than 0.");
        }
    }

    /**
     * Return's the room number as a String
     *
     * @return the ScreeningRoom as a String
     */
    public String toString() {
        return Integer.toString(aRoomNumber);
    }
}
