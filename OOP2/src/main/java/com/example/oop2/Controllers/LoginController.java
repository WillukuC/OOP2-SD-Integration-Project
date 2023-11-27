package com.example.oop2.Controllers;

import com.example.oop2.Models.Movie;
import com.example.oop2.Models.MovieList;
import javafx.event.ActionEvent;

import java.util.List;

public class LoginController {
    public void onEnter(ActionEvent actionEvent) {
        System.out.println("Placeholder");

        List<Movie> movieList  = MovieList.getMovieList();
        for (Movie movie : movieList) {
            System.out.println(movie.getTitle());
        }
        MovieList.addMovie(new Movie("Dune: Part Two", "Sci-Fi"));
        MovieList.saveMovieList();
    }
}
