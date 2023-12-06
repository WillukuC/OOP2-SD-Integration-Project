package com.example.oop2.Controllers;

import com.example.oop2.Models.SceneHelper;
import com.example.oop2.Models.ScreeningRoom;
import com.example.oop2.Models.ScreeningRoomList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import java.io.IOException;

public class ScreeningRoomDetailsController {
    @FXML
    private TextField roomNumberTextField;
    private int currentScreeningRoom = SceneHelper.getCurrentRoomID();

    @FXML
    private void initialize() {
        if (currentScreeningRoom != -1) {
            roomNumberTextField.setText(Integer.toString(currentScreeningRoom));
        }
    }

        @FXML
    private void onExitButtonClick(ActionEvent actionEvent) throws IOException {
        if (!roomNumberTextField.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Unsaved data. Are you sure you want to exit?");

            ButtonType buttonTypeExit = new ButtonType("Exit");
            ButtonType buttonTypeCancel = new ButtonType("Cancel");

            alert.getButtonTypes().setAll(buttonTypeExit, buttonTypeCancel);

            alert.showAndWait().ifPresent(buttonType -> {
                if (buttonType == buttonTypeExit) {
                    alert.close();
                    SceneHelper.closeWindow(roomNumberTextField);
                }
            });

        } else {
            SceneHelper.closeWindow(roomNumberTextField);
        }
    }

    @FXML
    private void onSaveButtonClick(ActionEvent actionEvent) throws IOException {
        int roomNumber = Integer.parseInt(roomNumberTextField.getText());
        ScreeningRoom newScreeningRoom = new ScreeningRoom(roomNumber);

        if (currentScreeningRoom < 0) {
            ScreeningRoomList.addScreeningRoom(newScreeningRoom);
        } else {
            ScreeningRoomList.updateScreeningRoom(currentScreeningRoom, newScreeningRoom);
        }

        SceneHelper.closeWindow(roomNumberTextField);
    }
}
