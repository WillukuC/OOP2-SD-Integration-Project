package com.example.oop2.Controllers;

import com.example.oop2.Models.*;
import javafx.event.ActionEvent;

import java.util.List;

public class LoginController {
    public void onEnter(ActionEvent actionEvent) {
        List<User> users = UserList.getUserList();
        for (User user : users ) {
            System.out.println(user.toString());
        }
    }
}
