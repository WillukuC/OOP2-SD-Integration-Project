package com.example.oop2.Models;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for managing the list of showtimes.
 * Upon initialization, fills the list with data from showtimes.csv
 */
public class ShowtimeList {
    /**
     * The global showtime list
     */
    private static final List<Showtime> showtimeList = new ArrayList<>();

    // Initialization method
    static {
        try {
            // The filepath to the list of showtimes.
            String filePath = "src\\main\\resources\\com\\example\\oop2\\Data\\showtimes.csv";

            // Tries to read the file at the specified path
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.US_ASCII))) {
                // Gets next line as string,
                // first readLine skips the file header.
                br.readLine();
                String line = br.readLine();

                // Executes if line is not null AND is not empty/whitespace
                while (line != null) {
                    if (!line.trim().isEmpty()) {
                        try {
                            // Splits the line into a showtime's id, date, and movie
                            // and adds it to the showtime list.
                            String[] attributes = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                            // Get showtime ID
                            int showtimeID = Integer.parseInt(attributes[0]);

                            // Get showtime DateTime
                            LocalDateTime showtimeDateTime = LocalDateTime.parse(attributes[1]);

                            // Get showtime Movie
                            Movie showtimeMovie = null;
                            for (Movie movie : MovieList.getMovieList()) {
                                if (movie.getTitle().equals(attributes[2])) {
                                    showtimeMovie = movie;
                                    break;
                                }
                            }

                            // Get showtime ScreeningRoom
                            ScreeningRoom showtimeRoom = null;
                            for (ScreeningRoom screeningRoom : ScreeningRoomList.getScreeningRoomList()) {
                                if (screeningRoom.toString().equals(attributes[3])) {
                                    showtimeRoom = screeningRoom;
                                    break;
                                }
                            }

                            Showtime showtime = new Showtime(showtimeID, showtimeDateTime, showtimeMovie, showtimeRoom);
                            addShowtime(showtime);
                        } catch (Exception ignored) { }
                    }
                    line = br.readLine();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating ShowtimeList instance");
        }
    }

    /**
     * ShowtimeList constructor, empty and private to prevent initialization
     */
    private ShowtimeList() {
    }

    /**
     * Gets the global showtime list
     *
     * @return the global showtime list
     */
    public static List<Showtime> getShowtimeList() {
        return showtimeList;
    }

    /**
     * Adds a showtime to the global showtime list.
     *
     * @param pShowtime The showtime to be added.
     */
    public static void addShowtime(Showtime pShowtime) {
        showtimeList.add(pShowtime);
        saveShowtimeList();
    }

    /**
     * Updates a showtime on the global showtime list.
     *
     * @param index     Index of the showtime to be updated
     * @param pShowtime The showtime with the changes made
     * @return true if the index is within the List's bounds, false if else.
     */
    public static boolean updateShowtime(int index, Showtime pShowtime) {
        // Checks if specified showtime is in the list range.
        if (index >= 0 && index <= showtimeList.size() - 1) {
            showtimeList.set(index, pShowtime);
            saveShowtimeList();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes a showtime from the global showtime list.
     *
     * @param pShowtime The showtime to be removed
     */
    public static void removeShowtime(Showtime pShowtime) {
        showtimeList.remove(pShowtime);
        saveShowtimeList();
    }

    /**
     * Saves the list of showtimes to showtimes.csv
     */
    public static void saveShowtimeList() {
        String filePath = "src\\main\\resources\\com\\example\\oop2\\Data\\showtimes.csv";
        String header = "ShowtimeID,DateTime,Movie,ScreeningRoom";
        DataHelper.saveData(filePath, header, getShowtimeList());
    }
}
