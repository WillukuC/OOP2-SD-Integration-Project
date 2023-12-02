package com.example.oop2.Controllers;

import com.example.oop2.Models.SceneHelper;
import com.example.oop2.Models.Ticket;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.IOException;

public class TicketSalesListController {
    @FXML
    private ListView<Ticket> ticketSalesListView;



    @FXML
    private void onExitButtonClick(ActionEvent actionEvent) throws IOException {
        System.out.println("onExitButtonClick");
        SceneHelper.changeScene("Views/dashboard-view.fxml", actionEvent);
    }
}
