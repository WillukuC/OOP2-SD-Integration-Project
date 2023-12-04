package com.example.oop2.Controllers;

import com.example.oop2.Models.*;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;


public class ShowtimeListController {
    private User aCurrentUser = SceneHelper.getCurrentUser();
    @FXML
    private TableView<Showtime> showtimeTableView;
    @FXML
    private void initialize() {
        TableColumn<Showtime, String> movieTitleColumn = new TableColumn<>("Movie Title");
        movieTitleColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getMovie().getTitle()));

        TableColumn<Showtime, String> movieGenreColumn = new TableColumn<>("Genre");
        movieGenreColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getMovie().getGenre()));

        TableColumn<Showtime, String> showtimeDateColumn = new TableColumn<>("Showtime Date");
        showtimeDateColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd\tHH:mm"))));

        showtimeTableView.getColumns().add(movieTitleColumn);
        showtimeTableView.getColumns().add(movieGenreColumn);
        showtimeTableView.getColumns().add(showtimeDateColumn);

        showtimeTableView.getItems().addAll(ShowtimeList.getShowtimeList());

        showtimeTableView.getSortOrder().add(showtimeDateColumn);
    }
    @FXML
    private void onBuyTicketButtonClick(){
        int ticketID = TicketList.getTicketList().size();
        int clientID = aCurrentUser.getID();
        LocalDateTime purchaseTime = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        Showtime showtime = showtimeTableView.getSelectionModel().getSelectedItem();

        TicketList.addTicket(new Ticket(ticketID, clientID, purchaseTime, showtime));
    }

    @FXML
    private void onUpdateButtonClick(ActionEvent actionEvent) throws IOException {
        System.out.println("onUpdateButtonClick");
        SceneHelper.changeScene("Views/showtime-details-view.fxml", actionEvent, "Showtime Details");
    }

    @FXML
    private void onAddButtonClick(ActionEvent actionEvent) throws IOException{
        System.out.println("onAddButtonClick");
        SceneHelper.changeScene("Views/showtime-details-view.fxml", actionEvent, "Showtime Details");
    }

    @FXML
    private void onDeleteButtonClick(){
        System.out.println("onDeleteButtonClick");
    }

    private void setCurrentUser(User pCurrentUser) {
        aCurrentUser = pCurrentUser;
    }
}
