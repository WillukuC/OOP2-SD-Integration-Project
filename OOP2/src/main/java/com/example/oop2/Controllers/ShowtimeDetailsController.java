package com.example.oop2.Controllers;

import com.example.oop2.Models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    /**
     * Sets the default values for the nodes if there's a selected showtime
     */
    @FXML
    private void initialize() {
        try {
            currentShowtime = ShowtimeList.getShowtimeByIndex(SceneHelper.getCurrentShowtime());
        } catch (Exception e) {
            currentShowtime = null;
        }

        if (currentShowtime != null) {
            //set the items in the choice boxes
            for (Movie movie : MovieList.getMovieList()) {
                movieChoiceBoxList.add(movie.getTitle());
            }
            movieChoiceBox.setItems(movieChoiceBoxList);
            for (ScreeningRoom room : ScreeningRoomList.getScreeningRoomList()) {
                roomChoiceBoxList.add(room.getRoomNumber());
            }
            screeningRoomChoiceBox.setItems(roomChoiceBoxList);

            //set the default values for the select showtime
            movieChoiceBox.getSelectionModel().select(currentShowtime.getMovie().getTitle());
            screeningRoomChoiceBox.getSelectionModel().select((Integer) currentShowtime.getScreeningRoom().getRoomNumber());
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
        if (!timeTextField.getText().trim().isEmpty() ||
            movieDateDatePicker.getValue() != null ||
            !screeningRoomChoiceBox.getSelectionModel().isEmpty() ||
            !movieChoiceBox.getSelectionModel().isEmpty())
        {
            SceneHelper.unsavedClose(timeTextField);
        } else {
            SceneHelper.closeWindow(timeTextField);
        }
    }

    /**
     * Saves the showtime data.
     *
     * @param actionEvent the button click event.
     * @throws IOException if the scene creation fails.
     */
    @FXML
    private void onSaveButtonClick(ActionEvent actionEvent) throws IOException{
        //check if the date chosen by the user is
        if (!movieDateDatePicker.getValue().isBefore(LocalDate.now())) {
            if (isValidTime(timeTextField.getText())){
                if (!movieChoiceBox.getSelectionModel().isEmpty()) {
                    if (!screeningRoomChoiceBox.getSelectionModel().isEmpty()){
                        System.out.println("success");

                        int showtimeID = ShowtimeList.getShowtimeList().size();
                        LocalDateTime showtimeDateTime = LocalDateTime.parse( movieDateDatePicker.getValue().toString() + " " + timeTextField.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                        Movie showtimeMovie = MovieList.getMovieByIndex(movieChoiceBox.getSelectionModel().getSelectedIndex());
                        ScreeningRoom showtimeRoom = ScreeningRoomList.getRoomByIndex(screeningRoomChoiceBox.getSelectionModel().getSelectedIndex());

                        Showtime newShowtime = new Showtime(showtimeID, showtimeDateTime, showtimeMovie, showtimeRoom);

                        if (currentShowtime == null) {
                            ShowtimeList.addShowtime(newShowtime);
                        } else {
                            ShowtimeList.updateShowtime(SceneHelper.getCurrentShowtime(), newShowtime);
                        }

                        // Successful save, closes window.
                        SceneHelper.closeWindow(timeTextField);

                    } else {
                        SceneHelper.errorMessage("A screening room must be selected");
                    }
                } else {
                    SceneHelper.errorMessage("A movie must be selected");
                }
            } else {
                SceneHelper.errorMessage("Enter a valid time in the format of HH:mm \n H being hours and m being minutes");
            }
        } else {
            SceneHelper.errorMessage("A new showtime cannot be in the past");
        }



    }

    private static boolean isValidTime(String time) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime.parse(time, formatter);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
