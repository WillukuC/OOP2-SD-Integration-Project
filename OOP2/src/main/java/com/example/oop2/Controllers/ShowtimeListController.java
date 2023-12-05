package com.example.oop2.Controllers;

import com.example.oop2.Models.*;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class ShowtimeListController {
    @FXML
    private Spinner<Integer> ticketSpinner = new Spinner<>();
    private final User aCurrentUser = SceneHelper.getCurrentUser();
    @FXML
    private TableView<Showtime> showtimeTableView;
    @FXML
    private void initialize() {
        ticketSpinner.setPromptText("# of tickets");

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
        Alert alert = new Alert(Alert.AlertType.WARNING);

        // Check if there is a selected showtime
        if (showtimeTableView.getSelectionModel().getSelectedIndex() == -1) {
            alert.setContentText("Please select a showtime.");
            alert.showAndWait();
        // Check if the number of tickets being purchased is more than 0
        } else if (ticketSpinner.getEditor().getText().trim().isEmpty() || Integer.parseInt(ticketSpinner.getEditor().getText()) < 1) {
            alert.setContentText("To make a purchase, you must enter at least 1 ticket.");
            alert.showAndWait();
        } else {
            // Set the number of tickets
            int nbOfTickets = Integer.parseInt(ticketSpinner.getEditor().getText());

            // Set the ticket data
            int ticketID = TicketList.getTicketList().size();
            int clientID = aCurrentUser.getID();
            LocalDateTime purchaseTime = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
            Showtime showtime = showtimeTableView.getSelectionModel().getSelectedItem();

            // Loop through the amount of tickets desired by the user, adding it to the ticket list
            for (int i = 0; i < nbOfTickets; i++) {
                TicketList.addTicket(new Ticket(ticketID, clientID, purchaseTime, showtime));

                // Increment the ticket ID so that every ID is unique
                ticketID++;
            }
        }
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
}
