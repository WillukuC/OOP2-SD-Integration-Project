package com.example.oop2.Models;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for managing the list of movies.
 * Upon initialization, fills the list with data from movies.csv
 */
public class MovieList {
    /**
     * The global movie list
     */
    private static final List<Movie> movieList = new ArrayList<>();

    // Initialization method
    static {
        try {
            // The filepath to the list of movies.
            String filePath = "src\\main\\resources\\com\\example\\oop2\\Data\\movies.csv";

            // Tries to read the file at the specified path
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.US_ASCII))) {
                // Gets next line as string,
                // first readLine skips the file header.
                br.readLine();
                String line = br.readLine();

                // Executes if line is not null AND is not empty/whitespace
                while (line != null) {
                    if (!line.trim().isEmpty()) {
                        // Splits the line into a movie's title and genre
                        // and adds it to the movie list.
                        String[] attributes = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                        Movie movie = new Movie(attributes[0], attributes[1]);
                        addMovie(movie);
                    }
                    line = br.readLine();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating MovieList instance: " + e);
        }
    }

    /**
     * MovieList constructor, empty and private to prevent initialization
     */
    private MovieList(){}

    /**
     * Gets the global movie list
     *
     * @return the global movie list
     */
    public static List<Movie> getMovieList() {
        return movieList;
    }

    /**
     * Adds a movie to the global movie list.
     *
     * @param pMovie The movie to be added.
     */
    public static void addMovie(Movie pMovie) {
        movieList.add(pMovie);
        saveMovieList();
    }

    /**
     * Updates a movie on the global movie list.
     *
     * @param index  Index of the movie to be updated
     * @param pMovie The movie with the changes made
     * @return true if the index is within the List's bounds, false if else.
     */
    public static boolean updateMovie(int index, Movie pMovie) {
        // Checks if specified movie is in the list range.
        if (index >= 0 && index <= movieList.size() - 1) {
            movieList.set(index, pMovie);
            saveMovieList();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes a movie from the global movie list.
     *
     * @param pMovie The movie to be removed
     */
    public static void removeMovie(Movie pMovie) {
        movieList.remove(pMovie);
        saveMovieList();
    }

    /**
     * Saves the list of movies to movies.csv
     */
    public static void saveMovieList() {
        String filePath = "src\\main\\resources\\com\\example\\oop2\\Data\\movies.csv";
        DataSaver.saveData(filePath, getMovieList());
    }
}