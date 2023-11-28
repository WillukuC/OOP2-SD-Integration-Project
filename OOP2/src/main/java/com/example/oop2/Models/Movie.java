package com.example.oop2.Models;

/**
 * Class for storing a movie's information
 */
public class Movie {
    /**
     * The title of the movie
     */
    private String aTitle;
    /**
     * The genre of the movie
     */
    private String aGenre;

    /**
     * The movie constructor
     *
     * @param pTitle The movie's title
     * @param pGenre The movie's genre
     */
    public Movie(String pTitle, String pGenre) {
        this.setTitle(pTitle);
        this.setGenre(pGenre);
    }

    /**
     * Get the movie's title
     *
     * @return The title of the movie
     */
    public String getTitle() {
        return aTitle;
    }

    /**
     * Set the movie's title
     *
     * @param pTitle The movie's new title
     */
    public void setTitle(String pTitle) {
        if (pTitle != null && !pTitle.trim().isEmpty()) {
            this.aTitle = pTitle;
        } else {
            throw new IllegalArgumentException("Invalid title. Please provide a non-empty title.");
        }
    }

    /**
     * Get the movie's genre
     *
     * @return The genre of the movie
     */
    public String getGenre() {
        return aGenre;
    }

    /**
     * Set the movie's genre
     *
     * @param pGenre The movie's new genre
     */
    public void setGenre(String pGenre) {
        if (pGenre != null && !pGenre.trim().isEmpty()) {
            this.aGenre = pGenre;
        } else {
            throw new IllegalArgumentException("Invalid genre. Please provide a non-empty genre.");
        }
    }

    /**
     * Returns the Movie as a single String
     * The returned String is formatted as "Title,Genre"
     *
     * @return The movie as a string
     */
    public String toString() {
        return this.aTitle + "," + this.aGenre;
    }
}
