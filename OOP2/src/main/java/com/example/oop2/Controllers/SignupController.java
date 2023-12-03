package com.example.oop2.Controllers;

import com.example.oop2.Models.SceneHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.io.IOException;

public class SignupController {
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField passwordTextField;

    @FXML
    private void onRegisterButtonClick(ActionEvent actionEvent) throws IOException {
        System.out.println("onRegisterButtonClick");
        SceneHelper.closeWindow(passwordTextField);
    }
}
