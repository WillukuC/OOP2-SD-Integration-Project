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

/**
 * Lets the manager enter a showtime's details to be added or updated
 */
public class ShowtimeDetailsController {
    @FXML
    private ChoiceBox<Movie> movieChoiceBox;
    @FXML
    private ChoiceBox<ScreeningRoom> screeningRoomChoiceBox;
    @FXML
    private DatePicker movieDateDatePicker;
    @FXML
    private TextField timeTextField;

    /**
     * Closes the current window
     *
     * @param actionEvent the button click event.
     * @throws IOException if the scene creation fails.
     */
    @FXML
    private void onExitButtonClick(ActionEvent actionEvent) throws IOException {
        SceneHelper.closeWindow(timeTextField);
    }

    /**
     * Saves the showtime data.
     *
     * @param actionEvent the button click event.
     * @throws IOException if the scene creation fails.
     */
    @FXML
    private void onSaveButtonClick(ActionEvent actionEvent) throws IOException{
        SceneHelper.closeWindow(timeTextField);
    }
}
