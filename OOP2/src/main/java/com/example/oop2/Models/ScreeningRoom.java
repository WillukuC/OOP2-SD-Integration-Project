package com.example.oop2.Models;

public class ScreeningRoom {
    private int aRoomNumber;

    public ScreeningRoom(int pRoomNumber) {
        this.setRoomNumber(pRoomNumber);
    }

    public void setRoomNumber(int pRoomNumber) {
        this.aRoomNumber = pRoomNumber;
    }

    public int getRoomNumber() {
        return aRoomNumber;
    }

    public String toString() {
        return Integer.toString(aRoomNumber);
    }
}
