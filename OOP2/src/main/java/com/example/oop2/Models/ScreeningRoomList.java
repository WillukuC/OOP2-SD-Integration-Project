package com.example.oop2.Models;

import javafx.stage.Screen;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ScreeningRoomList {
    private static final List<ScreeningRoom> screeningRoomList = new ArrayList<>();

    private ScreeningRoomList(){}

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
                        // Splits the line into a screening room's ID and room number.
                        // and adds it to the screening room list.
                        int roomNumber = Integer.parseInt(line);
                        ScreeningRoom screeningRoom = new ScreeningRoom(roomNumber);
                        addScreeningRoom (screeningRoom);
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
     * @param index Index of the screening room to be updated
     * @param pScreeningRoom The screening room with the changes made
     * @return true if the index is within the List's bounds, false if else.
     */
    public static boolean updateScreeningRoom(int index, ScreeningRoom pScreeningRoom) {
        // Checks if specified screening room is in the list range.
        if (index >= 0 && index <= screeningRoomList.size()-1) {
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
        try {
            // The filepath to the list of screening rooms.
            String filePath = "src\\main\\resources\\com\\example\\oop2\\Data\\screeningrooms.csv";

            // Writes over the file completely, adding each screening room in the list to the file.
            try (FileWriter fw = new FileWriter(filePath)) {
                // Writes the file header
                fw.append("RoomNumber").append(System.lineSeparator());
                for (ScreeningRoom screeningRoom : screeningRoomList) {
                    fw.append(screeningRoom.toString()).append(System.lineSeparator());
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to save list to file.");
        }
    }

}