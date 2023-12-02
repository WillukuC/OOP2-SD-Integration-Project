package com.example.oop2.Models;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *  Helper class that performs the saving and testing of data.
 */
public class DataHelper {
    /**
     * The global DataHelper
     */
    private final DataHelper aDataHelper = new DataHelper();

    /**
     * DataHelper constructor, empty and private to prevent initialization
     */
    private DataHelper(){}

    /**
     * Method for saving data to files.
     *
     * @param filePath  The path to the file data is being saved to
     * @param header    The header line of the file, which describes the attributes of the data
     * @param dataList  The list of data to be written to the file
     */
    public static void saveData(String filePath, String header, List dataList) {
        try {
            // Writes over the file completely, adding each data entry in the list to the file.
            try (FileWriter fw = new FileWriter(filePath)) {
                // Writes the file header
                fw.append(header).append(System.lineSeparator());
                // Adds each object in the list to the file
                for (Object o : dataList) {
                    fw.append(o.toString()).append(System.lineSeparator());
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to save list to file.");
        }
    }

    /**
     * Utility method to test if the data files can be properly read.
     * Prints all data to the console.
     */
    public static void testData(){
        System.out.println("\n-----===== MOVIES =====-----");
        List<Movie> movies = MovieList.getMovieList();
        for (Movie movie : movies) {
            System.out.println(movie.toString());
        }

        System.out.println("\n-----===== SCREENING ROOMS =====-----");
        List<ScreeningRoom> screeningRooms = ScreeningRoomList.getScreeningRoomList();
        for (ScreeningRoom screeningRoom : screeningRooms) {
            System.out.println(screeningRoom.toString());
        }

        System.out.println("\n-----===== SHOWTIMES =====-----");
        List<Showtime> showtimes = ShowtimeList.getShowtimeList();
        for (Showtime showtime : showtimes) {
            System.out.println(showtime.toString());
        }

        System.out.println("\n-----===== TICKETS =====-----");
        List<Ticket> tickets = TicketList.getTicketList();
        for (Ticket ticket : tickets) {
            System.out.println(ticket.toString());
        }

        System.out.println("\n-----===== USERS =====-----");
        List<User> users = UserList.getUserList();
        for (User user : users ) {
            System.out.println(user.toString());
        }
    }
}
