package com.example.oop2.Controllers;

import com.example.oop2.Models.*;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Displays the list of showtimes
 */
public class ShowtimeListController {
    @FXML
    private Button purchaseButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button addButton;
    @FXML
    private Button refreshButton;
    @FXML
    private Spinner<Integer> ticketSpinner = new Spinner<>();
    private final User aCurrentUser = SceneHelper.getCurrentUser();
    @FXML
    private TableView<Showtime> showtimeTableView;

    /**
     * Initializes the list of showtimes in the TableView.
     * Sets the movie, its genre and the day/time it is showing.
     */
    @FXML
    private void initialize() {
        ticketSpinner.setPromptText("# of tickets");

        showtimeTableView.getColumns().clear();
        showtimeTableView.getItems().clear();

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

        if (!aCurrentUser.isManager()) {
            //if the current user is not a manager, hide all CRUD buttons and disable them
            updateButton.setDisable(true);
            updateButton.setOpacity(0);
            deleteButton.setDisable(true);
            deleteButton.setOpacity(0);
            addButton.setDisable(true);
            addButton.setOpacity(0);
            refreshButton.setOpacity(0);
            refreshButton.setDisable(true);
        } else {
            //if the current user is a manager, hide all "buy ticket" controllers

            purchaseButton.setOpacity(0);
            purchaseButton.setDisable(true);
            ticketSpinner.setOpacity(0);
            ticketSpinner.setDisable(true);
        }
    }

    /**
     * Adds a ticket to the ticket list with the ClientID of the logged in client.
     * If multiple tickets selected, buys multiple.
     */
    @FXML
    private void onBuyTicketButtonClick(){

        // Check if there is a selected showtime
        if (showtimeTableView.getSelectionModel().getSelectedIndex() == -1) {
            SceneHelper.errorMessage("Please select a showtime.");
        // Check if the number of tickets being purchased is more than 0
        } else if (ticketSpinner.getEditor().getText().trim().isEmpty() || Integer.parseInt(ticketSpinner.getEditor().getText()) < 1) {
            SceneHelper.errorMessage("To make a purchase, you must enter at least 1 ticket.");
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
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Ticket bought");
            alert.setContentText(
                    "You have bought tickets for " + showtime.getMovie().getTitle() +
                            "\n The film starts on " + showtime.getDateTime().format(formatter)
            );
            alert.showAndWait();
        }
    }

    /**
     * Opens the Showtime Details controller in order to change the details of a showtime.
     *
     * @param actionEvent the button click event
     * @throws IOException if scene loading fails
     */
    @FXML
    private void onUpdateButtonClick(ActionEvent actionEvent) throws IOException {
        if (!showtimeTableView.getSelectionModel().isEmpty()) {
            SceneHelper.setCurrentShowtime(showtimeTableView.getSelectionModel().getSelectedIndex());
            SceneHelper.changeScene("Views/showtime-details-view.fxml", actionEvent, "Showtime Details");
        } else {
            SceneHelper.errorMessage("You haven't selected anything to update");
        }
    }

    /**
     * Opens the Showtime Details controller in order to add a new showtime to the list.
     *
     * @param actionEvent the button click event
     * @throws IOException if scene loading fails
     */
    @FXML
    private void onAddButtonClick(ActionEvent actionEvent) throws IOException{
        SceneHelper.changeScene("Views/showtime-details-view.fxml", actionEvent, "Showtime Details");
    }

    /**
     * Deletes the currently selected showtime from the list.
     */
    @FXML
    private void onDeleteButtonClick(){
        if (!showtimeTableView.getSelectionModel().isEmpty()) {
            if (SceneHelper.checkWithUser("Are you sure you want to delete this item")) {
                ShowtimeList.removeShowtime(showtimeTableView.getItems().get(showtimeTableView.getSelectionModel().getSelectedIndex()));
                initialize();
            }
        } else {
            SceneHelper.errorMessage("You haven't selected anything to delete");
        }
    }

    @FXML
    private void onRefreshButtonClick() {

    }
}