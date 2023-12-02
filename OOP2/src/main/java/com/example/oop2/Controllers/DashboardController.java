package com.example.oop2.Controllers;

import com.example.oop2.Models.SceneHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class DashboardController {

    @FXML
    private void onGoMovieButtonClick(ActionEvent actionEvent) throws IOException {
        System.out.println("onGoMovieButtonClick");
        SceneHelper.changeScene("Views/movie-list-view.fxml", actionEvent);
    }

    @FXML
    private void onGoShowtimesButtonClick(ActionEvent actionEvent) throws IOException{
        System.out.println("onGoShowtimesButtonClick");
        SceneHelper.changeScene("Views/showtime-list-view.fxml", actionEvent);
    }

    @FXML
    private void onGoScreeningRoomsButtonClick(ActionEvent actionEvent) throws IOException {
        System.out.println("onGoScreeningRoomsButtonClick");
        SceneHelper.changeScene("Views/screeningroom-list-view.fxml", actionEvent);
    }

    @FXML
    private void onClientListButtonClick(ActionEvent actionEvent) throws IOException {
        System.out.println("onClientListButtonClick");
        SceneHelper.changeScene("Views/client-list-view.fxml", actionEvent);
    }

    @FXML
    private void onTicketSalesButtonClick(ActionEvent actionEvent) throws IOException{
        System.out.println("onTicketSalesButtonClick");
        SceneHelper.changeScene("Views/ticketsales-list-view.fxml", actionEvent);
    }
}
