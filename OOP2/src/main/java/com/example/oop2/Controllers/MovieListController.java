package com.example.oop2.Controllers;

import com.example.oop2.Models.*;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

public class MovieListController {
    @FXML
    private TableView<Movie> movieTableView;

    @FXML
    private void initialize() {
        movieTableView.getColumns().clear();
        movieTableView.getItems().clear();

        TableColumn<Movie, String> movieTitleColumn = new TableColumn<>("Title");
        movieTitleColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getTitle()));

        TableColumn<Movie, String> movieGenreColumn = new TableColumn<>("Genre");
        movieGenreColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getGenre()));

        movieTableView.getColumns().add(movieTitleColumn);
        movieTableView.getColumns().add(movieGenreColumn);

        movieTableView.getItems().addAll(MovieList.getMovieList());
    }

    @FXML
    private void onUpdateButtonClick(ActionEvent actionEvent) throws IOException {
        SceneHelper.setCurrentMovie(movieTableView.getSelectionModel().getSelectedIndex());
        SceneHelper.changeScene("Views/movie-details-view.fxml", actionEvent, "Movie Details");
    }

    @FXML
    private void onAddButtonClick(ActionEvent actionEvent) throws IOException{
        SceneHelper.setCurrentMovie(-1);
        SceneHelper.changeScene("Views/movie-details-view.fxml", actionEvent, "Movie Details");
    }

    @FXML
    private void onDeleteButtonClick(){
        MovieList.removeMovie(movieTableView.getItems().get(movieTableView.getSelectionModel().getSelectedIndex()));
    }


    public void onRefreshButtonClick(ActionEvent actionEvent) {
        initialize();
    }
}
