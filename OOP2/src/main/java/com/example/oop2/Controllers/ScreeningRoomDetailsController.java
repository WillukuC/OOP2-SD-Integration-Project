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

/**
 * Lets the manager enter a screening room's details to be added or updated
 */
public class ScreeningRoomDetailsController {
    @FXML
    private TextField roomNumberTextField;
    private int currentScreeningRoom = SceneHelper.getCurrentRoomID();

    /**
     * Sets the text field to the current screening room, if there is one.
     */
    @FXML
    private void initialize() {
        if (currentScreeningRoom != -1) {
            roomNumberTextField.setText(Integer.toString(currentScreeningRoom));
        }
    }

    /**
     * Alerts the user if data has been unsaved and prompts a confirmation.
     *
     * @param actionEvent button click action
     * @throws IOException if loading a scene fails.
     */
    @FXML
    private void onExitButtonClick(ActionEvent actionEvent) throws IOException {
        if (!roomNumberTextField.getText().trim().isEmpty()) {
            if (SceneHelper.checkWithUser("Changes haven't been saved\nContinue?")) {
                SceneHelper.closeWindow(roomNumberTextField);
            }
        } else {
            SceneHelper.closeWindow(roomNumberTextField);
        }
    }

    /**
     * If room number, saves and closes the controller.
     * If not, shows warning to the user.
     *
     * @param actionEvent button click action
     * @throws IOException if loading a scene fails.
     */
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
