package com.example.oop2.Controllers;

import com.example.oop2.Models.SceneHelper;
import com.example.oop2.Models.ScreeningRoom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import java.io.IOException;

public class ScreeningRoomListController {
    @FXML
    private ListView<ScreeningRoom> screeningRoomListListView;



    @FXML
    private void onUpdateButtonClick(ActionEvent actionEvent) throws IOException {
        System.out.println("onUpdateButtonClick");
        SceneHelper.changeScene("Views/screeningroom-details-view.fxml", actionEvent);
    }

    @FXML
    private void onAddButtonClick(ActionEvent actionEvent) throws IOException {
        System.out.println("onAddButtonClick");
        SceneHelper.changeScene("Views/screeningroom-details-view.fxml", actionEvent);
    }

    @FXML
    private void onDeleteButtonClick(){
        System.out.println("onDeleteButtonClick");
    }
}
