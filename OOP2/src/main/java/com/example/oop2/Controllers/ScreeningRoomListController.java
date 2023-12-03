package com.example.oop2.Controllers;

import com.example.oop2.Models.SceneHelper;
import com.example.oop2.Models.ScreeningRoom;
import com.example.oop2.Models.ScreeningRoomList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import java.io.IOException;
import javafx.stage.Stage;

public class ScreeningRoomListController {
    @FXML
    private ListView<ScreeningRoom> screeningRoomListView;
    @FXML
    private Button closeButton;
    @FXML
    private void initialize() {
        screeningRoomListView.setItems(FXCollections.observableArrayList(ScreeningRoomList.getScreeningRoomList()));
    }

    @FXML
    private void onUpdateButtonClick(ActionEvent actionEvent) throws IOException {
        System.out.println("onUpdateButtonClick");
        SceneHelper.changeScene("Views/screeningroom-details-view.fxml", actionEvent, "Screening Room Details");
    }

    @FXML
    private void onAddButtonClick(ActionEvent actionEvent) throws IOException {
        System.out.println("onAddButtonClick");
        SceneHelper.changeScene("Views/screeningroom-details-view.fxml", actionEvent, "Screening Room Details");
    }

    @FXML
    private void onDeleteButtonClick(){
        ScreeningRoom selectedRoom = screeningRoomListView.getSelectionModel().getSelectedItem();
        ScreeningRoomList.removeScreeningList(selectedRoom);
        initialize();
    }
    @FXML
    public void onCloseButtonClick() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
