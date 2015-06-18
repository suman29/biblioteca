package com.twu.movies;

import com.twu.Messages;
import com.twu.users.Customer;

import java.util.ArrayList;

// This is the available movie, which can checkout itself and this class converts a checkout movie to a available movie.

public class AvailableMovie extends Movie {
    public AvailableMovie(String name, int year, String director, int rating) {
        super(name, year, director, rating);
    }

    @Override
    public void checkOut(ArrayList<Movie> allMovies, Customer customer) {
        allMovies.remove(this);
        allMovies.add(CheckedOutMovie.create(this, customer));
    }

    @Override
    public void returnMovie(ArrayList<Movie> list) {
    }

    @Override
    public void addItselfToAvailableListOfMovieIfApplicable(ArrayList<Movie> availableMovies) {
        availableMovies.add(this);
    }

    @Override
    public String getAppropriateMessageOnCheckOutAction() {
        return Messages.CHECKOUT_MOVIE_SUCCESSFUL;
    }

    @Override
    public String getAppropriateMessageOnReturnMovieAction() {
        return Messages.MOVIE_ALREADY_AVAILABLE;
    }

    @Override
    public void addItselfToCheckedoutListOfMovieIfApplicable(ArrayList<Movie> checkedOutMovies) {

    }

    public static AvailableMovie create(CheckedOutMovie checkedOutMovie) {
        return new AvailableMovie(checkedOutMovie.name, checkedOutMovie.year, checkedOutMovie.director, checkedOutMovie.rating);
    }
}
