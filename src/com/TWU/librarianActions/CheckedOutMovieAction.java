package com.twu.librarianActions;

import com.twu.Library;
import com.twu.Option;
import com.twu.movies.Movie;
import com.twu.users.Customer;

import java.util.ArrayList;

public class CheckedOutMovieAction implements Option {
    private Library library;
    private ArrayList<Movie> movies;

    public CheckedOutMovieAction(Library library, ArrayList<Movie> movies) {
        this.library = library;
        this.movies = movies;
    }

    @Override
    public void perform(Customer customer) {
        library.getCheckedOutMovies(movies);
        for (Movie movie : movies)
            System.out.println(movie.toString());

    }
}
