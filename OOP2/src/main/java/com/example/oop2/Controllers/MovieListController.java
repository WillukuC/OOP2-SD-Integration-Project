package com.example.oop2.Controllers;

import com.example.oop2.Models.Movie;
import com.example.oop2.Models.SceneHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.IOException;

public class MovieListController {
    @FXML
    private ListView<Movie> movieListListView;


    @FXML
    private void onUpdateButtonClick(ActionEvent actionEvent) throws IOException {
        System.out.println("onUpdateButtonClick");
        SceneHelper.changeScene("Views/movie-details-view.fxml", actionEvent);
    }

    @FXML
    private void onAddButtonClick(ActionEvent actionEvent) throws IOException{
        System.out.println("onAddButtonClick");
        SceneHelper.changeScene("Views/movie-details-view.fxml", actionEvent);
    }

    @FXML
    private void onDeleteButtonClick(){
        System.out.println("onDeleteButtonClick");

    }
}
