package com.example.oop2.Controllers;

import com.example.oop2.Models.SceneHelper;
import com.example.oop2.Models.User;
import com.example.oop2.Models.UserList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

/**
 * Displays the list of clients.
 */
public class ClientListController {
    @FXML
    private ListView<String> clientListview;

    /**
     * Populates the listView with the usernames of every existing user.
     */
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

    /**
     * Closes the window.
     */
    @FXML
    private void onCloseButtonClick(){
        SceneHelper.closeWindow(clientListview);
    }
}
