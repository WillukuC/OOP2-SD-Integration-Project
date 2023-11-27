package com.example.oop2.Models;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MovieList {
    private static final List<Movie> movieList = new ArrayList<>();

    private MovieList(){}

    static {
        try {
            String filePath = "src\\main\\resources\\com\\example\\oop2\\Data\\movies.csv";
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.US_ASCII))) {
                br.readLine();
                String line = br.readLine();
                while (line != null) {
                    if (!line.equals("")) {
                        String[] attributes = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                        Movie movie = new Movie(attributes[0], attributes[1]);
                        addMovie(movie);
                        line = br.readLine();
                    }
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating MovieList instance");
        }
    }

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
    }

    /**
     * Updates a movie on the global movie list.
     *
     * @param index Index of the movie to be updated
     * @param pMovie The movie with the changes made
     * @return true if the index is within the List's bounds, false if else.
     */
    public static boolean updateMovie(int index, Movie pMovie) {
        if (index >= 0 && index <= movieList.size()-1) {
            movieList.set(index, pMovie);
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
    }

    public static void saveMovieList() {
        try {
            String filePath = "src\\main\\resources\\com\\example\\oop2\\Data\\movies.csv";
            try (FileWriter fw = new FileWriter(filePath)) {
                for (Movie movie : movieList) {
                    fw.append(movie.getTitle()).append(",").append(movie.getGenre()).append(System.lineSeparator());
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to save list to file.");
        }
    }

}
