package com.example.oop2.Models;

public class Movie {
    private String aTitle;
    private String aGenre;

    public Movie(String pTitle, String pGenre) {
        this.setTitle(pTitle);
        this.setGenre(pGenre);
    }

    public void setTitle(String pTitle) {
        this.aTitle = pTitle;
    }

    public String getTitle() {
        return aTitle;
    }

    public void setGenre(String pGenre) {
        this.aGenre = pGenre;
    }

    public String getGenre() {
        return aGenre;
    }

    public String toString() {
        return this.aTitle + "," + this.aGenre;
    }
}
