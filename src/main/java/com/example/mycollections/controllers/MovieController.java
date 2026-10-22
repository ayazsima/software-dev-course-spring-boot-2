package com.example.mycollections.controllers;

import com.example.mycollections.models.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final List<Movie> movies = new ArrayList<>(List.of(
            new Movie("Inception", 2010, "Christopher Nolan", 148),
            new Movie("Titanic", 1997, "James Cameron", 194),
            new Movie("The Matrix", 1999, "Lana and Lilly Wachowski", 136),
            new Movie("Interstellar", 2014, "Christopher Nolan", 169)
    ));

    @GetMapping("/json")
    public List<Movie> getMoviesJson(){
        return movies;
    }
    @GetMapping("/html")
    public String getMoviesHtml(){
        String movieList = "";
        for(Movie movie : movies){
            movieList += "<li>" + movie + "</li>";
        }

        return """
                <html>
                <body>
                <h1>Movies</h1>
                <ul>
                """
                + movieList

                + """
                </ul>
                </body>
                </html>
                """;
    }
}
