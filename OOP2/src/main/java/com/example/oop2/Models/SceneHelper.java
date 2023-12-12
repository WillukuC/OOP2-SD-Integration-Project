package com.example.oop2.Models;

import com.example.oop2.MovieTheatreApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Utility class for managing scenes
 * You can use changeScene and closeWindow to manage scenes
 */
public class SceneHelper {
    /**
     * The SceneHelper class
     */
    private static final SceneHelper sh = new SceneHelper();
    /**
     * The application's current user
     */
    private static User aCurrentUser = null;
    /**
     * The id of the room currently being edited
     */
    private static int aCurrentRoomID = -1;
    /**
     * The id of the movie currently being edited
     */
    private static int aCurrentMovie = -1;
    /**
     * The id of the showtime currently being edited
     */
    private static int aCurrentShowtime = -1;

    /**
     * changeScene changes to the desired scene by passing the destination, an ActionEvent and a title
     * @param destination String holding the destination view
     * @param pEvent Determines the source of the event
     * @param title String that holds the title of the scene
     * */
    public static void changeScene(String destination, ActionEvent pEvent, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MovieTheatreApplication.class.getResource(destination));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = new Stage();
        nextStage.setScene(nextScene);
        nextStage.setTitle(title);
        nextStage.initModality(Modality.WINDOW_MODAL);
        nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
        nextStage.showAndWait();
    }

    /**
     * closeWindow closes the current window using a node to get the current scene
     * @param node Gets a node from the scene to then close the scene the node is from
     * */
    public static void closeWindow(Node node) {
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    public static void unsavedClose(Node node) {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Unsaved data. Are you sure you want to exit?");

        ButtonType buttonTypeExit = new ButtonType("Exit");
        ButtonType buttonTypeCancel = new ButtonType("Cancel");

        alert.getButtonTypes().setAll(buttonTypeExit, buttonTypeCancel);

        alert.showAndWait().ifPresent(buttonType -> {
            if (buttonType == buttonTypeExit) {
                alert.close();
                SceneHelper.closeWindow(node);
            }
        });
    }

    public static void errorMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Warning");
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Sets the current user
     *
     * @param pCurrentUser the logged-in user
     */
    public static void setCurrentUser(User pCurrentUser) {
        aCurrentUser = pCurrentUser;
    }

    /**
     * Gets the current user
     *
     * @return the logged-in user
     */
    public static User getCurrentUser() {
        return aCurrentUser;
    }
    /**
     * Sets the edited room ID
     *
     * @param pCurrentRoomID the ID of the room being edited
     */
    public static void setCurrentRoomID(int pCurrentRoomID) {
        aCurrentRoomID = pCurrentRoomID;
    }

    /**
     * Gets the ID of the room being edited
     *
     * @return the ID of the current room being edited
     */
    public static int getCurrentRoomID() {
        return aCurrentRoomID;
    }

    /**
     * Sets the current movie ID
     *
     * @param pCurrentMovie the ID of the movie being edited
     */
    public static void setCurrentMovie(int pCurrentMovie) {
        aCurrentMovie = pCurrentMovie;
    }

    /**
     * Gets the current movie ID
     *
     * @return the ID of the movie being edited
     */
    public static int getCurrentMovie() {
        return aCurrentMovie;
    }

    /**
     * Sets the current showtime ID
     *
     * @param pCurrentShowtime the ID of the showtime being edited
     */
    public static void setCurrentShowtime(int pCurrentShowtime) {
        aCurrentShowtime = pCurrentShowtime;
    }


    /**
     * Gets the current showtime ID
     *
     * @return the ID of the showtime being edited
     */
    public static int getCurrentShowtime() {
        return aCurrentShowtime;
    }
}
