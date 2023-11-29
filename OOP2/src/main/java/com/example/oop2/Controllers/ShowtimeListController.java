package com.example.oop2.Controllers;

import com.example.oop2.Models.Showtime;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ShowtimeListController {
    @FXML
    private ListView<Showtime> showtimeListListView;



    @FXML
    private void onBuyTicketButtonClick(){
        System.out.println("onBuyTicketButtonClick");

    }

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
