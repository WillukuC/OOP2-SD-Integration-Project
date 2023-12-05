package com.example.oop2.Models;

import com.example.oop2.MovieTheatreApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Utility class for managing scenes
 * You can use changeScene and closeWindow to manage scenes
 */
public class SceneHelper {
    private static final SceneHelper sh = new SceneHelper();
    private static User aCurrentUser = null;
    private static int aCurrentRoomID = -1;

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

    public static void setCurrentUser(User pCurrentUser) {
        aCurrentUser = pCurrentUser;
    }

    public static User getCurrentUser() {
        return aCurrentUser;
    }
    public static void setCurrentRoomID(int pCurrentRoomID) {
        aCurrentRoomID = pCurrentRoomID;
    }
    public static int getCurrentRoomID() {
        return aCurrentRoomID;
    }
}
