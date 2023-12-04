package com.example.oop2.Controllers;

import com.example.oop2.Models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordTextField;

    public void onEnter(ActionEvent actionEvent) throws IOException {
        // Gets the username and password from the text fields
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        // Creates a new alert
        Alert alert = new Alert(Alert.AlertType.WARNING);

        if (username.trim().isEmpty()) {
            alert.setContentText("Please enter your username.");
            alert.showAndWait();
        } else if (UserList.getUserByUsername(username) == null) {
            alert.setContentText("The username is incorrect. Please re-enter your username.");
            alert.showAndWait();
        } else if (password.trim().isEmpty()) {
            alert.setContentText("Please enter your password.");
            alert.showAndWait();
        } else {
            User user = UserList.getUserByUsername(username);
            assert user != null;
            if (!user.isCorrectPassword(password)) {
                alert.setContentText("The password is incorrect. Please re-enter your password.");
                alert.showAndWait();
            } else {
                if (user.isManager()) {
                    SceneHelper.closeWindow(passwordTextField);
                    SceneHelper.changeScene("Views/dashboard-view.fxml", actionEvent, "Dashboard");
                } else {
                    SceneHelper.setCurrentUser(user);
                    SceneHelper.closeWindow(passwordTextField);
                    SceneHelper.changeScene("Views/showtime-list-view.fxml", actionEvent, "Showtimes");
                }
            }
        }
    }

    @FXML
    private void onSignUpButtonClick(ActionEvent pEvent) throws IOException {
        DataHelper.testData();
        System.out.println("onSignUpButtonClick");
        SceneHelper.changeScene("Views/signup-view.fxml", pEvent, "Sign-Up");
    }

}
