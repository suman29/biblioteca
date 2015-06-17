package com.twu.movies;

import com.twu.Messages;

import java.util.ArrayList;

public class NullMovie extends Movie {
    public NullMovie(String name, int year, String director, int rating) {
        super(name, year, director, rating);
    }

    @Override
    public void checkOut(ArrayList<Movie> list) {

    }

    @Override
    public void returnMovie(ArrayList<Movie> list) {

    }

    @Override
    public void addItselfToAvailableListOfMovieIfApplicable(ArrayList<Movie> availableMovies) {

    }

    @Override
    public String getAppropriateMessageOnCheckOutAction() {
        System.out.println(Messages.CHECKOUT_MOVIE_UNSUCCESSFUL);
        return null;
    }

    @Override
    public String getAppropriateMessageOnReturnMovieAction() {
        System.out.println(Messages.RETURN_MOVIE_UNSUCCESSFUL);
        return null;
    }
}
