package com.example.oop2.Controllers;

import com.example.oop2.Models.Movie;
import com.example.oop2.Models.MovieList;
import com.example.oop2.Models.SceneHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import java.io.IOException;

/**
 * Lets the manager enter a movie's details to be added or updated
 */
public class MovieDetailsController {
    @FXML
    private TextField movieTitleTextField;
    @FXML
    private TextField movieGenreTextField;
    private Movie currentMovie;

    /**
     * Fills the text fields with the movie data if updating,
     * leaves them empty if adding a new movie.
     */
    @FXML
    private void initialize() {
        try {
            currentMovie = MovieList.getMovieByIndex(SceneHelper.getCurrentMovie());
        } catch (Exception e) {
            currentMovie = null;
        }

        if (currentMovie != null) {
            movieTitleTextField.setText(currentMovie.getTitle());
            movieGenreTextField.setText(currentMovie.getGenre());
        }
    }

    /**
     * If title and genre are present, saves and closes the controller.
     * If not, shows warning to the user.
     *
     * @throws IOException if one or both textFields are empty.
     */
    @FXML
    private void onSaveButtonClick() throws IOException {
        try {
            String movieTitle = movieTitleTextField.getText();
            String movieGenre = movieGenreTextField.getText();

            if (movieTitle.contains(",") && (movieTitle.charAt(0) != '"' || movieTitle.charAt(movieTitle.length()-1) == '"')) {
                movieTitle = "\"" + movieTitle + "\"";
            }

            Movie newMovie = new Movie(movieTitle, movieGenre);

            if (currentMovie == null) {
                MovieList.addMovie(new Movie(movieTitle, movieGenre));
            } else {
                MovieList.updateMovie(SceneHelper.getCurrentMovie(), newMovie);
            }

            // Successful save, closes window.
            SceneHelper.closeWindow(movieTitleTextField);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter both title and genre.");
            alert.showAndWait();
        }
    }

    /**
     * Alerts the user if data has been unsaved and prompts a confirmation.
     *
     * @param actionEvent button click action
     * @throws IOException if loading a scene fails.
     */
    @FXML
    private void onExitButtonClick(ActionEvent actionEvent) throws IOException{
        if (!movieGenreTextField.getText().trim().isEmpty() || !movieTitleTextField.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Unsaved data. Are you sure you want to exit?");

            ButtonType buttonTypeExit = new ButtonType("Exit");
            ButtonType buttonTypeCancel = new ButtonType("Cancel");

            alert.getButtonTypes().setAll(buttonTypeExit, buttonTypeCancel);

            alert.showAndWait().ifPresent(buttonType -> {
                if (buttonType == buttonTypeExit) {
                    alert.close();
                    SceneHelper.closeWindow(movieTitleTextField);
                }
            });

        } else {
            SceneHelper.closeWindow(movieTitleTextField);
        }    }
}
