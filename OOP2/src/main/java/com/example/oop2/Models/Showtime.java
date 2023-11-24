package com.example.oop2.Models;

import java.time.LocalDateTime;

public class Showtime {
    private LocalDateTime aTime;
    private Movie aMovie;

    public Showtime(LocalDateTime aTime, Movie aMovie, Showtime aShowtime) {
        this.aTime = aTime;
        this.aMovie = aMovie;
        this.aShowtime = aShowtime;
    }

    public void setTime(LocalDateTime aTime) {
        this.aTime = aTime;
    }

    public void setMovie(Movie aMovie) {
        this.aMovie = aMovie;
    }

    public void setShowtime(Showtime aShowtime) {
        this.aShowtime = aShowtime;
    }

    public LocalDateTime getTime() {
        return aTime;
    }

    public Movie getMovie() {
        return aMovie;
    }

    public Showtime getShowtime() {
        return aShowtime;
    }

    private Showtime aShowtime;
}
