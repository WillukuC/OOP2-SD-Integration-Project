package com.example.oop2.Controllers;

import com.example.oop2.Models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class LoginController {
    public void onEnter(ActionEvent actionEvent) {

        System.out.println("\n-----===== MOVIES =====-----");
        List<Movie> movies = MovieList.getMovieList();
        for (Movie movie : movies) {
            System.out.println(movie.toString());
        }

        System.out.println("\n-----===== SCREENING ROOMS =====-----");
        List<ScreeningRoom> screeningRooms = ScreeningRoomList.getScreeningRoomList();
        for (ScreeningRoom screeningRoom : screeningRooms) {
            System.out.println(screeningRoom.toString());
        }

        System.out.println("\n-----===== SHOWTIMES =====-----");
        List<Showtime> showtimes = ShowtimeList.getShowtimeList();
        for (Showtime showtime : showtimes) {
            System.out.println(showtime.toString());
        }

        System.out.println("\n-----===== TICKETS =====-----");
        List<Ticket> tickets = TicketList.getTicketList();
        for (Ticket ticket : tickets) {
            System.out.println(ticket.toString());
        }

        System.out.println("\n-----===== USERS =====-----");
        List<User> users = UserList.getUserList();
        for (User user : users ) {
            System.out.println(user.toString());
        }


        boolean isCorrect = false;

        for (User user : UserList.getUserList()) {
            if (user.getUsername().equals(usernameTextField.getText())) {
                if (checkPassword(user)) {
                    if (!user.isIsManager()) {
                        System.out.println("Open Showtime list");
                    }
                    else {
                        System.out.println("Open Dashboard");
                    }
                }
                isCorrect = true;
            }
        }
        if (!isCorrect) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "The username is wrong");
            alert.showAndWait();
        }
    }

    private boolean checkPassword(User user) {
        if (user.getPassword().equals(passwordTextField.getText())) {
            return true;
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "The password is wrong");
            alert.showAndWait();
        }
        return false;
    }


    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;

    @FXML
    private void onSignUpButtonClick(){
        System.out.println("onSignUpButtonClick");

    }
}
