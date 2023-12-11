package com.example.oop2.Models;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for managing the list of users.
 * Upon initialization, fills the list with data from users.csv
 */
public class UserList {
    /**
     * The global user list
     */
    private static final List<User> userList = new ArrayList<>();

    // Initialization method
    static {
        try {
            // The filepath to the list of users.
            String filePath = "src\\main\\resources\\com\\example\\oop2\\Data\\users.csv";

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
                            // Splits the line into a user's id, username, email, join date, password and manager status
                            // and adds it to the user list.
                            String[] attributes = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                            // Get user ID
                            int userID = Integer.parseInt(attributes[0]);

                            // Get username
                            String username = attributes[1];

                            // Get email
                            String email = attributes[2];

                            // Get DateTime joined
                            LocalDateTime joinDateTime = LocalDateTime.parse(attributes[3]);

                            // Get Password
                            String password = attributes[4];

                            // Get isManager
                            boolean isManager = Boolean.parseBoolean(attributes[5]);

                            User user = new User(userID, username, email, joinDateTime, password, isManager);
                            addUser(user);
                        } catch (Exception ignored) { }
                    }
                    line = br.readLine();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating UserList instance");
        }
    }

    /**
     * UserList constructor, empty and private to prevent initialization
     */
    private UserList() {
    }

    /**
     * Gets the global user list
     *
     * @return the global user list
     */
    public static List<User> getUserList() {
        return userList;
    }

    /**
     * Adds a user to the global user list.
     *
     * @param pUser The user to be added.
     */
    public static void addUser(User pUser) {
        userList.add(pUser);
        saveUserList();
    }

    /**
     * Updates a user on the global user list.
     *
     * @param index Index of the user to be updated
     * @param pUser The user with the changes made
     * @return true if the index is within the List's bounds, false if else.
     */
    public static boolean updateUser(int index, User pUser) {
        // Checks if specified user is in the list range.
        if (index >= 0 && index <= userList.size() - 1) {
            userList.set(index, pUser);
            saveUserList();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes a user from the global user list.
     *
     * @param pUser The user to be removed
     */
    public static void removeUser(User pUser) {
        userList.remove(pUser);
        saveUserList();
    }

    /**
     * Saves the list of users to users.csv
     */
    public static void saveUserList() {
        String filePath = "src\\main\\resources\\com\\example\\oop2\\Data\\users.csv";
        String header = "UserID,Username,Email,DateTimeJoined,Password,IsManager";
        DataHelper.saveData(filePath, header, getUserList());
    }

    /**
     * Checks the list if the given username exists on the list
     *
     * @param pUsername the username to be checked
     * @return the user the username belongs to if it exists, null if no such user exists
     */
    public static User getUserByUsername(String pUsername) {
        for (User user : userList) {
            if (pUsername.equals(user.getUsername())) {
                return user;
            }
        }
        return null;
    }
}
