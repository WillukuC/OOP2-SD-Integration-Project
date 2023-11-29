package com.example.oop2.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    public void onEnter(ActionEvent actionEvent) {
        System.out.println("Placeholder");
    }

    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;


    @FXML
    private void onLoginButtonClick(){
        System.out.println("onLoginButtonClick");

    }

    @FXML
    private void onSignUpButtonClick(){
        System.out.println("onSignUpButtonClick");

    }
}
