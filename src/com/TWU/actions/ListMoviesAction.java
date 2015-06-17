package com.twu.actions;

import com.twu.Library;
import com.twu.Option;
import com.twu.movies.Movie;

import java.util.ArrayList;

public class ListMoviesAction implements Option {
    private Library library;
    private ArrayList<Movie> movies;

    public ListMoviesAction(Library library, ArrayList<Movie> movies) {
        this.library = library;

        this.movies = movies;
    }

    @Override
    public void perform() {
        ArrayList<Movie> allMovies = library.getAvailableMovies(movies);
        for (Movie movie : allMovies)
            System.out.println(movie.toString());
    }

}
