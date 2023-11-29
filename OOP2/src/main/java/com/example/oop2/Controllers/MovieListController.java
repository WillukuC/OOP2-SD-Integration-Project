package com.example.oop2.Controllers;

import com.example.oop2.Models.Movie;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class MovieListController {
    @FXML
    private ListView<Movie> movieListListView;


    @FXML
    private void onUpdateButtonClick(){
        System.out.println("onUpdateButtonClick");

    }

    @FXML
    private void onAddButtonClick(){
        System.out.println("onAddButtonClick");

    }

    @FXML
    private void onDeleteButtonClick(){
        System.out.println("onDeleteButtonClick");

    }
}
