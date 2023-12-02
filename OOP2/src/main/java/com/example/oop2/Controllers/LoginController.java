package com.example.oop2.Controllers;

import com.example.oop2.Models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginController {
    public void onEnter(ActionEvent actionEvent) {
        boolean isCorrect = false;

        for (User user : UserList.getUserList()) {
            if (user.getUsername().equals(usernameTextField.getText())) {
                if (checkPassword(user)) {
                    if (!user.isManager()) {
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
    private void onSignUpButtonClick(ActionEvent pEvent) throws IOException {
        DataHelper.testData();
        System.out.println("onSignUpButtonClick");
        SceneHelper.changeScene("Views/signup-view.fxml", pEvent);
    }
}
