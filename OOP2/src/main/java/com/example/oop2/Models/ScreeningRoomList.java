package com.example.oop2.Models;

import javafx.collections.FXCollections;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for managing the list of screening rooms.
 * Upon initialization, fills the list with data from screeningrooms.csv
 */
public class ScreeningRoomList {
    /**
     * The global screening room list
     */
//    private static final List<ScreeningRoom> screeningRoomList = new ArrayList<>();
    private static final List<ScreeningRoom> screeningRoomList = FXCollections.observableArrayList();


    // Initialization method
    static {
        try {
            // The filepath to the list of screening rooms.
            String filePath = "src\\main\\resources\\com\\example\\oop2\\Data\\screeningrooms.csv";

            // Tries to read the file at the specified path
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.US_ASCII))) {
                // Gets next line as string,
                // first readLine skips the file header.
                br.readLine();
                String line = br.readLine();

                // Executes if line is not null AND is not empty/whitespace
                while (line != null) {
                    if (!line.trim().isEmpty()) {
                        // Gets the line as the room's number
                        // and adds it to the screening room list.
                        int roomNumber = Integer.parseInt(line);
                        ScreeningRoom screeningRoom = new ScreeningRoom(roomNumber);
                        addScreeningRoom(screeningRoom);
                    }
                    line = br.readLine();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating ScreeningList instance");
        }
    }

    /**
     * ScreeningRoomList constructor, empty and private to prevent initialization
     */
    private ScreeningRoomList() {
    }

    /**
     * Gets the global screening room list
     *
     * @return the global screening room list
     */
    public static List<ScreeningRoom> getScreeningRoomList() {
        return screeningRoomList;
    }

    /**
     * Adds a screening room to the global screening room list.
     *
     * @param pScreeningRoom The screening room to be added.
     */
    public static void addScreeningRoom(ScreeningRoom pScreeningRoom) {
        screeningRoomList.add(pScreeningRoom);
        saveScreeningRoomList();
    }

    /**
     * Updates a screening room on the global screening room list.
     *
     * @param index          Index of the screening room to be updated
     * @param pScreeningRoom The screening room with the changes made
     * @return true if the index is within the List's bounds, false if else.
     */
    public static boolean updateScreeningRoom(int index, ScreeningRoom pScreeningRoom) {
        // Checks if specified screening room is in the list range.
        if (index >= 0 && index <= screeningRoomList.size() - 1) {
            screeningRoomList.set(index, pScreeningRoom);
            saveScreeningRoomList();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes a screening room from the global screening room list.
     *
     * @param pScreeningList The screening room to be removed
     */
    public static void removeScreeningList(ScreeningRoom pScreeningList) {
        screeningRoomList.remove(pScreeningList);
        saveScreeningRoomList();
    }

    /**
     * Saves the list of screening rooms to screeningrooms.csv
     */
    public static void saveScreeningRoomList() {
        String filePath = "src\\main\\resources\\com\\example\\oop2\\Data\\screeningrooms.csv";
        String header = "RoomNumber";
        DataHelper.saveData(filePath, header, getScreeningRoomList());
    }
}
