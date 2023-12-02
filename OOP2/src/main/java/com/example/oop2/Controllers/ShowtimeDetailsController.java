package com.example.oop2.Controllers;

import com.example.oop2.Models.Movie;
import com.example.oop2.Models.SceneHelper;
import com.example.oop2.Models.ScreeningRoom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ShowtimeDetailsController {
    @FXML
    private ChoiceBox<Movie> movieChoiceBox;
    @FXML
    private ChoiceBox<ScreeningRoom> screeningRoomChoiceBox;
    @FXML
    private DatePicker movieDateDatePicker;
    @FXML
    private TextField timeTextField;



    @FXML
    private void onExitButtonClick(ActionEvent actionEvent) throws IOException {
        System.out.println("onExitButtonClick");
        SceneHelper.changeScene("Views/showtime-list-view.fxml", actionEvent);
    }

    @FXML
    private void onSaveButtonClick(ActionEvent actionEvent) throws IOException{
        System.out.println("onSaveButtonClick");
        SceneHelper.changeScene("Views/showtime-list-view.fxml", actionEvent);
    }
}
