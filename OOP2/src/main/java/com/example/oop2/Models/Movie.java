package com.example.oop2.Models;

public class Movie {
    private String aTitle;
    private String aGenre;

    public Movie(String aTitle, String aGenre) {
        this.aTitle = aTitle;
        this.aGenre = aGenre;
    }

    public void setTitle(String aTitle) {
        this.aTitle = aTitle;
    }

    public void setGenre(String aGenre) {
        this.aGenre = aGenre;
    }

    public String getTitle() {
        return aTitle;
    }

    public String getGenre() {
        return aGenre;
    }
}
