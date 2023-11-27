package com.example.oop2.Models;

import java.time.LocalDateTime;

/**
 * Class for storing a showtime's information
 */
public class Showtime {
    /**
     * The showtime id
     */
    private int aID;
    /**
     * The date and time at which the showtime is scheduled
     */
    private LocalDateTime aDateTime;
    /**
     * The movie being shown at the showtime
     */
    private Movie aMovie;
    /**
     * The screening room in which the showtime takes place
     */
    private ScreeningRoom aScreeningRoom;

    /**
     * The showtime constructor
     *
     * @param pID The showtime's ID
     * @param pDateTime The showtime's scheduled date and time
     * @param pMovie The showtime's movie
     * @param pScreeningRoom The showtime's allotted room
     */
    public Showtime(int pID, LocalDateTime pDateTime, Movie pMovie, ScreeningRoom pScreeningRoom) {
        this.setID(pID);
        this.setDateTime(pDateTime);
        this.setMovie(pMovie);
        this.setScreeningRoom(pScreeningRoom);
    }

    /**
     * Returns the showtime's ID
     *
     * @return The ID of the showtime
     */
    public int getID() {
        return this.aID;
    }

    public void setID(int pID) {
        this.aID = pID;
    }

    /**
     * Returns the showtime's date and time
     *
     * @return The date and time of the showtime
     */
    public LocalDateTime getDateTime() {
        return aDateTime;
    }

    public void setDateTime(LocalDateTime pDateTime) {
        this.aDateTime = pDateTime;
    }

    /**
     * Returns the showtime's movie
     *
     * @return The movie of the showtime
     */
    public Movie getMovie() {
        return aMovie;
    }

    public void setMovie(Movie pMovie) {
        this.aMovie = pMovie;
    }

    /**
     * Returns the showtime's screening room
     *
     * @return The screening room of the showtime
     */
    public ScreeningRoom getScreeningRoom() {
        return aScreeningRoom;
    }

    public void setScreeningRoom(ScreeningRoom pScreeningRoom) {
        this.aScreeningRoom = pScreeningRoom;
    }

    /**
     * Return's the showtime as a String.
     * The format is "ID,DateTime,MovieTitle,ScreeningRoomNumber"
     *
     * @return the showtime as a String
     */
    public String toString() {
        return aID + "," +
                aDateTime.toString() + "," +
                aMovie.getTitle() + "," +
                aScreeningRoom.getRoomNumber();
    }
}
