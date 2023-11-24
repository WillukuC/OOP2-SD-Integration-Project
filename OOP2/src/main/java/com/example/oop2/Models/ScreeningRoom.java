package com.example.oop2.Models;

public class ScreeningRoom {
    private int aRandomNumber;

    public ScreeningRoom(int aRandomNumber) {
        this.aRandomNumber = aRandomNumber;
    }

    public void setRandomNumber(int aRandomNumber) {
        this.aRandomNumber = aRandomNumber;
    }

    public int getRandomNumber() {
        return aRandomNumber;
    }
}
