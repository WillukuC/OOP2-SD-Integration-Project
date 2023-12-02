package com.example.oop2.Models;

import com.example.oop2.MovieTheatreApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.EventObject;


public class SceneHelper {
    private static final SceneHelper sh = new SceneHelper();

    public static void changeScene(String destination, ActionEvent pEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MovieTheatreApplication.class.getResource(destination));
        Scene nextScene = new Scene(fxmlLoader.load());
        Stage nextStage = new Stage();
        nextStage.setScene(nextScene);
        nextStage.setTitle("test");
        nextStage.initModality(Modality.WINDOW_MODAL);
        nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
        nextStage.showAndWait();
    }
}
