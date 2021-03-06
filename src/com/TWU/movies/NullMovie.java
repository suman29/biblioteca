package com.twu.movies;

import com.twu.Messages;
import com.twu.users.Customer;

import java.util.ArrayList;

// It is created when user gives some invalid input.

public class NullMovie extends Movie {
    private Customer customer;

    public NullMovie(String name, int year, String director, int rating, Customer customer) {
        super(name, year, director, rating);
        this.customer = customer;
    }

    @Override
    public void checkOut(ArrayList<Movie> list, Customer customer) {

    }

    @Override
    public void returnMovie(ArrayList<Movie> list) {

    }

    @Override
    public void addItselfToAvailableListOfMovieIfApplicable(ArrayList<Movie> availableMovies) {

    }

    @Override
    public String getAppropriateMessageOnCheckOutAction() {
        return (Messages.CHECKOUT_MOVIE_UNSUCCESSFUL);

    }

    @Override
    public String getAppropriateMessageOnReturnMovieAction() {
        return (Messages.RETURN_MOVIE_UNSUCCESSFUL);

    }

    @Override
    public void addItselfToCheckedoutListOfMovieIfApplicable(ArrayList<Movie> checkedOutMovies) {

    }

    public String toString(){
        return Messages.MOVIE_NOT_FOUND;
    }
}
