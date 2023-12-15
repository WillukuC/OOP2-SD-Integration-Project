package com.example.oop2.Controllers;

import com.example.oop2.Models.SceneHelper;
import com.example.oop2.Models.ScreeningRoom;
import com.example.oop2.Models.ScreeningRoomList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import java.io.IOException;
import javafx.stage.Stage;

/**
 * Displays the list of screening rooms.
 */
public class ScreeningRoomListController {
    @FXML
    private ListView<ScreeningRoom> screeningRoomListView;
    @FXML
    private Button closeButton;

    /**
     * Writes all the screening rooms to the list view
     */
    @FXML
    private void initialize() {
        screeningRoomListView.setItems(FXCollections.observableArrayList(ScreeningRoomList.getScreeningRoomList()));
    }

    /**
     * Opens the screening room details controller,
     * setting the current room to the selected one
     *
     * @param actionEvent button click
     * @throws IOException in case of error when loading scene
     */
    @FXML
    private void onUpdateButtonClick(ActionEvent actionEvent) throws IOException {
        SceneHelper.setCurrentRoomID(screeningRoomListView.getSelectionModel().getSelectedIndex());
        SceneHelper.changeScene("Views/screeningroom-details-view.fxml", actionEvent, "Screening Room Details");
    }

    /**
     * Opens the screening room details controller,
     * setting the current room to none
     *
     * @param actionEvent button click
     * @throws IOException in case of error when loading scene
     */
    @FXML
    private void onAddButtonClick(ActionEvent actionEvent) throws IOException {
        SceneHelper.setCurrentRoomID(-1);
        SceneHelper.changeScene("Views/screeningroom-details-view.fxml", actionEvent, "Screening Room Details");
    }

    /**
     * Removes the selected screening room from the list
     */
    @FXML
    private void onDeleteButtonClick(){
        if (SceneHelper.checkWithUser("Are you sure you want to delete this item")) {
            ScreeningRoom selectedRoom = screeningRoomListView.getSelectionModel().getSelectedItem();
            ScreeningRoomList.removeScreeningList(selectedRoom);
        }
    }

    /**
     * Closes the current window
     */
    @FXML
    public void onCloseButtonClick() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    /**
     *
     */
    @FXML
    public void onRefreshButtonClick() {
        initialize();
    }
}
