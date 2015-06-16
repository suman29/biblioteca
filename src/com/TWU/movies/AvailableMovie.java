package com.twu.movies;

import com.twu.Messages;

import java.util.ArrayList;

// This is the available movie, which can checkout itself and this class converts a checkout movie to a available movie.

public class AvailableMovie extends Movie {
    public AvailableMovie(String name, int year, String director, int rating) {
        super(name, year, director, rating);
    }

    @Override
    public void checkOut(ArrayList<Movie> allMovies) {
        allMovies.remove(this);
        allMovies.add(CheckedOutMovies.create(this));
    }

    @Override
    public void returnMovie(ArrayList<Movie> list) {
    }

    @Override
    public void addItselfToAvailableListOfMovieIfApplicable(ArrayList<Movie> availableMovies) {
        availableMovies.add(this);
    }

    @Override
    public void getAppropriateMessageOnCheckOutAction() {
        System.out.println(Messages.CHECKOUT_MOVIE_SUCCESSFUL);
    }

    @Override
    public void getAppropriateMessageOnReturnMovieAction() {
        System.out.print(Messages.MOVIE_ALREADY_AVAILABLE);
    }

    public static AvailableMovie create(CheckedOutMovies checkedOutMovies) {
        return new AvailableMovie(checkedOutMovies.name, checkedOutMovies.year, checkedOutMovies.director, checkedOutMovies.rating);
    }
}
