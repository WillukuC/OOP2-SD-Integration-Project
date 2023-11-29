package com.example.oop2.Controllers;

import com.example.oop2.Models.ScreeningRoom;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ScreeningRoomListController {
    @FXML
    private ListView<ScreeningRoom> screeningRoomListListView;



    @FXML
    private void onUpdateButtonClick(){
        System.out.println("onUpdateButtonClick");

    }

    @FXML
    private void onAddButtonClick(){
        System.out.println("onAddButtonClick");

    }

    @FXML
    private void onDeleteButtonClick(){
        System.out.println("onDeleteButtonClick");

    }
}
