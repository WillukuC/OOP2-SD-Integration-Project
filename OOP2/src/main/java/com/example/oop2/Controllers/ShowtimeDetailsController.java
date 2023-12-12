package com.example.oop2.Controllers;

import com.example.oop2.Models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

/**
 * Lets the manager enter a showtime's details to be added or updated
 */
public class ShowtimeDetailsController {
    @FXML
    private ChoiceBox<String> movieChoiceBox;
    @FXML
    private ChoiceBox<Integer> screeningRoomChoiceBox;
    @FXML
    private DatePicker movieDateDatePicker;
    @FXML
    private TextField timeTextField;

    private Showtime currentShowtime;

    ObservableList<String> movieChoiceBoxList = FXCollections.observableArrayList();

    ObservableList<Integer> roomChoiceBoxList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        try {
            currentShowtime = ShowtimeList.getShowtimeByIndex(SceneHelper.getCurrentShowtime());
        } catch (Exception e) {
            currentShowtime = null;
        }

        if (currentShowtime != null) {
            for (Movie movie : MovieList.getMovieList()) {
                movieChoiceBoxList.add(movie.getTitle());
            }
            movieChoiceBox.setItems(movieChoiceBoxList);

            for (ScreeningRoom room : ScreeningRoomList.getScreeningRoomList()) {
                roomChoiceBoxList.add(room.getRoomNumber());
            }
            screeningRoomChoiceBox.setItems(roomChoiceBoxList);

            movieDateDatePicker.setValue(currentShowtime.getDateTime().toLocalDate());

            timeTextField.setText(currentShowtime.getDateTime().format(DateTimeFormatter.ofPattern("HH:mm")));
        }
    }

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
