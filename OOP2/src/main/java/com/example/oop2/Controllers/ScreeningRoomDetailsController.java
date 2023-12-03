package com.example.oop2.Controllers;

import com.example.oop2.Models.SceneHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.io.IOException;

public class ScreeningRoomDetailsController {
    @FXML
    private TextField roomNumberTextField;

    @FXML
    private void onExitButtonClick(ActionEvent actionEvent) throws IOException {
        System.out.println("onExitButtonClick");
        SceneHelper.closeWindow(roomNumberTextField);
    }

    @FXML
    private void onSaveButtonClick(ActionEvent actionEvent) throws IOException {
        System.out.println("onSaveButtonClick");
        SceneHelper.closeWindow(roomNumberTextField);
    }
}
