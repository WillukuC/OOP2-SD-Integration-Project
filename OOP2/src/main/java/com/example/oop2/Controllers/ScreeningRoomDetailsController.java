package com.example.oop2.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ScreeningRoomDetailsController {
    @FXML
    private TextField roomNumberTextField;



    @FXML
    private void onExitButtonClick(){
        System.out.println("onExitButtonClick");

    }

    @FXML
    private void onSaveButtonClick(){
        System.out.println("onSaveButtonClick");

    }
}
