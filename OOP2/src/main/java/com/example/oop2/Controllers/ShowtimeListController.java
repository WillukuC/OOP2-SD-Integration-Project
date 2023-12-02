package com.example.oop2.Controllers;

import com.example.oop2.Models.SceneHelper;
import com.example.oop2.Models.Showtime;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.IOException;


public class ShowtimeListController {
    @FXML
    private ListView<Showtime> showtimeListListView;



    @FXML
    private void onBuyTicketButtonClick(){
        System.out.println("onBuyTicketButtonClick");

    }

    @FXML
    private void onUpdateButtonClick(ActionEvent actionEvent) throws IOException {
        System.out.println("onUpdateButtonClick");
        SceneHelper.changeScene("Views/showtime-details-view.fxml", actionEvent);
    }

    @FXML
    private void onAddButtonClick(ActionEvent actionEvent) throws IOException{
        System.out.println("onAddButtonClick");
        SceneHelper.changeScene("Views/showtime-details-view.fxml", actionEvent);
    }

    @FXML
    private void onDeleteButtonClick(){
        System.out.println("onDeleteButtonClick");

    }
}
