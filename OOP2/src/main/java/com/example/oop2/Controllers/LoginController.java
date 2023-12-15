package com.example.oop2.Controllers;

import com.example.oop2.Models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Application login view
 */
public class LoginController {
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;

    /**
     * On enter, logs the user into the application.
     *
     * @param actionEvent the input, either clicking the button or pressing enter.
     * @throws IOException in case of error when loading scene
     */
    public void onEnter(ActionEvent actionEvent) throws IOException {
        // Gets the username and password from the text fields
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        if (username.trim().isEmpty()) {
            SceneHelper.errorMessage("Please enter your username.");
        } else if (UserList.getUserByUsername(username) == null) {
            SceneHelper.errorMessage("The username is incorrect. Please re-enter your username.");
        } else if (password.trim().isEmpty()) {
            SceneHelper.errorMessage("Please enter your password.");
        } else {
            User user = UserList.getUserByUsername(username);
            assert user != null;
            if (!user.isCorrectPassword(password)) {
                SceneHelper.errorMessage("The password is incorrect. Please re-enter your password.");
            } else {
                if (user.isManager()) {
                    SceneHelper.setCurrentUser(user);
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

    /**
     * Opens the client sign-up controller.
     *
     * @param pEvent button click event
     * @throws IOException in case of scene load failure
     */
    @FXML
    private void onSignUpButtonClick(ActionEvent pEvent) throws IOException {
        SceneHelper.changeScene("Views/signup-view.fxml", pEvent, "Sign-Up");
    }

}
