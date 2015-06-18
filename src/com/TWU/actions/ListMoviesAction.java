package com.twu.actions;

import com.twu.Library;
import com.twu.menu.Option;
import com.twu.movies.Movie;
import com.twu.users.User;

import java.util.ArrayList;

// It displays all the movies available in library.

public class ListMoviesAction implements Option {
    private Library library;
    private ArrayList<Movie> movies;

    public ListMoviesAction(Library library, ArrayList<Movie> movies) {
        this.library = library;

        this.movies = movies;
    }

    @Override
    public void perform(User customer) {
        ArrayList<Movie> allMovies = library.getAvailableMovies(movies);
        for (Movie movie : allMovies)
            System.out.println(movie.toString());
    }

    @Override
    public void perform() {
        ArrayList<Movie> allMovies = library.getAvailableMovies(movies);
        for (Movie movie : allMovies)
            System.out.println(movie.toString());
    }

}
