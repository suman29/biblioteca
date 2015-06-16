package com.twu.movies;

import com.twu.Library;
import com.twu.Option;

import java.util.ArrayList;

public class ListMoviesAction implements Option {
    private Library library;

    public ListMoviesAction(Library library) {
        this.library = library;
    }

    @Override
    public void perform() {
        ArrayList<Movie> allMovies = library.getMovies();
        for (Movie movie : allMovies)
            System.out.println(movie.toString());
    }

}
