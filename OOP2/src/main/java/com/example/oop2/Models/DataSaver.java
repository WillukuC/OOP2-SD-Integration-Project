package com.example.oop2.Models;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 */
public class DataSaver {
    private final DataSaver aDataSaver = new DataSaver();
    private DataSaver(){}
    public static void saveData(String filePath, List dataList) {
        try {
            // The filepath to the list of movies.
            filePath = "src\\main\\resources\\com\\example\\oop2\\Data\\movies.csv";

            // Writes over the file completely, adding each movie in the list to the file.
            try (FileWriter fw = new FileWriter(filePath)) {
                // Writes the file header
                fw.append("Title,Genre").append(System.lineSeparator());
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
}
