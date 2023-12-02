package com.example.oop2.Controllers;

import com.example.oop2.Models.User;
import com.example.oop2.Models.UserList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class ClientListController {

    @FXML
    private ListView<String> clientListview;
    @FXML
    private Button closeButton;
    @FXML
    public void initialize() {
        ObservableList<String> clientList = FXCollections.observableArrayList();
        for (User client : UserList.getUserList()) {
            if (!client.isManager()) {
                clientList.add(client.getUsername());
            }
        }
        clientListview.setItems(clientList);
    }
    @FXML
    private void onCloseButtonClick(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
