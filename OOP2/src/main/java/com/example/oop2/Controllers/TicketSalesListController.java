package com.example.oop2.Controllers;

import com.example.oop2.Models.SceneHelper;
import com.example.oop2.Models.Ticket;
import com.example.oop2.Models.TicketList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class TicketSalesListController {
    @FXML
    private ListView<Ticket> ticketSalesListView = new ListView<>();

    @FXML
    private void initialize() {
        ObservableList<Ticket> itemsList = FXCollections.observableArrayList
                (TicketList.getTicketList());
        ticketSalesListView.setItems(itemsList);
    }


    @FXML
    private void onExitButtonClick(){
        System.out.println("onExitButtonClick");
        SceneHelper.closeWindow(ticketSalesListView);
    }
}
