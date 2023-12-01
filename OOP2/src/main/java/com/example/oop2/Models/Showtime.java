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

    /**
     * Sets the showtime's date and time
     *
     * @param pDateTime The new date and time of the showtime
     */
    public void setDateTime(LocalDateTime pDateTime) {
        if (pDateTime != null) {
            this.aDateTime = pDateTime;
        } else {
            throw new IllegalArgumentException("Invalid date. Please provide a date that is before or equal to the current date.");
        }
    }

    /**
     * Returns the showtime's movie
     *
     * @return The movie of the showtime
     */
    public Movie getMovie() {
        return aMovie;
    }

    /**
     * Set the Movie of the showtime
     *
     * @param pMovie the showtime's new movie
     */
    public void setMovie(Movie pMovie) {
        if (pMovie != null && MovieList.getMovieList().contains(pMovie)) {
            this.aMovie = pMovie;
        } else {
            throw new IllegalArgumentException("Invalid Movie. Please provide a valid movie.");
        }
    }

    /**
     * Returns the showtime's screening room
     *
     * @return The screening room of the showtime
     */
    public ScreeningRoom getScreeningRoom() {
        return aScreeningRoom;
    }

    /**
     * Sets the screening room of the showtime
     *
     * @param pScreeningRoom The showtime's new screening room
     */
    public void setScreeningRoom(ScreeningRoom pScreeningRoom) {
        if (pScreeningRoom.getRoomNumber() > 0 && ScreeningRoomList.getScreeningRoomList().contains(pScreeningRoom)) {
            this.aScreeningRoom = pScreeningRoom;
        } else {
            throw new IllegalArgumentException("Invalid Screening Room. Please provide a valid screening room.");
        }
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
