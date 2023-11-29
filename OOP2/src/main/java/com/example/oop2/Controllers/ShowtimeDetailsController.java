package com.example.oop2.Controllers;

import com.example.oop2.Models.Movie;
import com.example.oop2.Models.ScreeningRoom;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

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
    private void onExitButtonClick(){
        System.out.println("onExitButtonClick");

    }

    @FXML
    private void onSaveButtonClick(){
        System.out.println("onSaveButtonClick");

    }
}
