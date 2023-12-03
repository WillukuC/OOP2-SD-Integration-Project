package com.example.oop2.Controllers;

import com.example.oop2.Models.SceneHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.io.IOException;

public class MovieDetailsController {
    @FXML
    private TextField movieTitleTextField;
    //@FXML
    //private ChoiceBox<Genre> movieGenreChoiceBox; /*we're gonna need a genre class*/


    @FXML
    private void onSaveButtonClick(ActionEvent actionEvent) throws IOException {
        System.out.println("onSaveButtonClick");
        SceneHelper.closeWindow(movieTitleTextField);
    }

    @FXML
    private void onExitButtonClick(ActionEvent actionEvent) throws IOException{
        System.out.println("onExitButtonClick");
        SceneHelper.closeWindow(movieTitleTextField);
    }
}
