package com.example.oop2.Controllers;

import com.example.oop2.Models.*;
import javafx.event.ActionEvent;

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
    }
}
