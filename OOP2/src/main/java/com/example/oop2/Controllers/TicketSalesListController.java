package com.example.oop2.Controllers;

import com.example.oop2.Models.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.lang.String;
import java.time.format.DateTimeFormatter;

public class TicketSalesListController {
    @FXML
    private TableView<Ticket> ticketSalesTableView;

    @FXML
    private void initialize() {

        TableColumn<Ticket, String> ticketIdColumn = new TableColumn<>("Ticket ID");
        ticketIdColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getTicketID()));

        TableColumn<Ticket, Integer> clientIdColumn = new TableColumn<>("Client ID");
        clientIdColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getClientID()));

        TableColumn<Ticket, String> purchaseDateColumn = new TableColumn<>("Purchase Date");
        purchaseDateColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getPurchaseDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd\tHH:mm"))));

        TableColumn<Ticket, String> showtimeColumn = new TableColumn<>("Show Time");
        showtimeColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getShowtime().getDateTime()));

        TableColumn<Ticket, String> movieColumn = new TableColumn<>("Movie Title");
        movieColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getShowtime().getMovie().getTitle()));

        ticketSalesTableView.getColumns().add(ticketIdColumn);
        ticketSalesTableView.getColumns().add(clientIdColumn);
        ticketSalesTableView.getColumns().add(showtimeColumn);
        ticketSalesTableView.getColumns().add(movieColumn);

        ticketSalesTableView.getItems().addAll(TicketList.getTicketList());

        ticketSalesTableView.getSortOrder().add(ticketIdColumn);
    }


    @FXML
    private void onExitButtonClick(){
        System.out.println("onExitButtonClick");
        SceneHelper.closeWindow(ticketSalesTableView);
    }
}
