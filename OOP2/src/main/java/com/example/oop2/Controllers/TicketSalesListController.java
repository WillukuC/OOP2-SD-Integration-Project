package com.example.oop2.Controllers;

import com.example.oop2.Models.Ticket;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class TicketSalesListController {
    @FXML
    private ListView<Ticket> ticketSalesListView;



    @FXML
    private void onExitButtonClick(){
        System.out.println("onExitButtonClick");

    }
}
