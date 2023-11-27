package com.example.oop2.Controllers;

import com.example.oop2.Models.*;
import javafx.event.ActionEvent;

import java.util.List;

public class LoginController {
    public void onEnter(ActionEvent actionEvent) {
        List<Showtime> showtimes = ShowtimeList.getShowtimeList();
        System.out.println(showtimes.get(1).toString());
    }
}
