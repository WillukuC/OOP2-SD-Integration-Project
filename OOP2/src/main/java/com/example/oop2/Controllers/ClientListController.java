package com.example.oop2.Controllers;

import com.example.oop2.Models.User;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ClientListController {


    @FXML
    private ListView<User> clientListListview;
    @FXML
    private void onExitButtonClick(){
        System.out.println("onExitButtonClick");
    }
}
