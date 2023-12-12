package com.example.oop2.Controllers;

import com.example.oop2.Models.SceneHelper;
import com.example.oop2.Models.User;
import com.example.oop2.Models.UserList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import java.time.LocalDateTime;

/**
 * Allows a new user to sign up for the application.
 */
public class SignupController {
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField passwordTextField;

    /**
     * Checks if the email, username and password are valid.
     * Creates new user if yes, closing the window.
     */
    @FXML
    private void onRegisterButtonClick() {
        try {
            if (emailTextField.getText().trim().isEmpty() || !emailTextField.getText().contains("@") || !emailTextField.getText().contains(".")) {
                SceneHelper.errorMessage("Please enter a valid email address.");
            } else if (nameTextField.getText().trim().isEmpty()) {
                SceneHelper.errorMessage("Please enter a username.");
            } else if (passwordTextField.getText().trim().isEmpty()) {
                SceneHelper.errorMessage("Please enter a password.");
            } else {
                int newUserID = UserList.getUserList().size();
                String newUsername = nameTextField.getText();
                String newUserEmail = emailTextField.getText();
                LocalDateTime accountCreationTime = LocalDateTime.now();
                String newUserPassword = passwordTextField.getText();

                UserList.addUser(new User(newUserID, newUsername, newUserEmail, accountCreationTime, newUserPassword, false));

                SceneHelper.closeWindow(passwordTextField);
            }
        } catch (Exception e) {
            SceneHelper.errorMessage("Unexpected error.");
        }
    }
}
