package com.example.oop2.Models;
import java.time.LocalDateTime;

public class Showtime {
    private int aID;
    private LocalDateTime aDateTime;
    private Movie aMovie;
    private ScreeningRoom aScreeningRoom;

    public Showtime(int pID, LocalDateTime pDateTime, Movie pMovie, ScreeningRoom pScreeningRoom) {
        this.setID(pID);
        this.setDateTime(pDateTime);
        this.setMovie(pMovie);
        this.setScreeningRoom(pScreeningRoom);
    }

    public void setID(int pID) {
        this.aID = pID;
    }

    public int getID(){
        return this.aID;
    }

    public void setDateTime(LocalDateTime pDateTime) {
        this.aDateTime = pDateTime;
    }

    public LocalDateTime getDateTime() {
        return aDateTime;
    }

    public void setMovie(Movie pMovie) {
        this.aMovie = pMovie;
    }

    public Movie getMovie() {
        return aMovie;
    }

    public void setScreeningRoom(ScreeningRoom pScreeningRoom) {
        this.aScreeningRoom = pScreeningRoom;
    }

    public ScreeningRoom getScreeningRoom() {
        return aScreeningRoom;
    }

    public String toString() {
        return aID + "," +
                aDateTime.toString() + "," +
                aMovie.getTitle() + "," +
                aScreeningRoom.getRoomNumber();
    }
}
