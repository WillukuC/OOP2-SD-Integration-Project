package com.example.oop2.Controllers;

import com.example.oop2.Models.SceneHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

/**
 * Navigation controller for the manager
 * Allows manager to access all relevant lists
 */
public class DashboardController {
    /**
     * Opens the movie list controller
     *
     * @param actionEvent button click
     * @throws IOException in case of error when loading scene
     */
    @FXML
    private void onGoMovieButtonClick(ActionEvent actionEvent) throws IOException {
        SceneHelper.changeScene("Views/movie-list-view.fxml", actionEvent, "Movies");
    }

    /**
     * Opens the showtimes list controller
     *
     * @param actionEvent button click
     * @throws IOException in case of error when loading scene
     */
    @FXML
    private void onGoShowtimesButtonClick(ActionEvent actionEvent) throws IOException{
        SceneHelper.changeScene("Views/showtime-list-view.fxml", actionEvent, "Showtimes");
    }

    /**
     * Opens the screening rooms list controller
     *
     * @param actionEvent button click
     * @throws IOException in case of error when loading scene
     */
    @FXML
    private void onGoScreeningRoomsButtonClick(ActionEvent actionEvent) throws IOException {
        SceneHelper.changeScene("Views/screeningroom-list-view.fxml", actionEvent, "Screening Rooms");
    }

    /**
     * Opens the client list controller
     *
     * @param actionEvent button click
     * @throws IOException in case of error when loading scene
     */
    @FXML
    private void onClientListButtonClick(ActionEvent actionEvent) throws IOException {
        SceneHelper.changeScene("Views/client-list-view.fxml", actionEvent, "Clients");
    }

    /**
     * Opens the ticket sales controller
     *
     * @param actionEvent button click
     * @throws IOException in case of error when loading scene
     */
    @FXML
    private void onTicketSalesButtonClick(ActionEvent actionEvent) throws IOException{
        SceneHelper.changeScene("Views/ticketsales-list-view.fxml", actionEvent, "Ticket Sales");
    }
}
