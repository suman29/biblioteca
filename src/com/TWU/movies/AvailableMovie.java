package com.twu.movies;

import java.util.ArrayList;

public class AvailableMovie extends Movie {
    public AvailableMovie(String name, int year, String director, int rating) {
        super(name, year, director, rating);
    }

    @Override
    public void checkOut(ArrayList<Movie> list) {

    }

    @Override
    public void returnMovie(ArrayList<Movie> list) {

    }

    public static AvailableMovie create(CheckedOutMovies checkedOutMovies) {
        return new AvailableMovie(checkedOutMovies.name, checkedOutMovies.year, checkedOutMovies.director, checkedOutMovies.rating);
    }
}
