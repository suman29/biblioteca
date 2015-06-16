package com.twu.movies;

import com.twu.Messages;

import java.util.ArrayList;

public class CheckedOutMovies extends Movie {
    public CheckedOutMovies(String name, int year, String director, int rating) {
        super(name, year, director, rating);
    }

    @Override
    public void checkOut(ArrayList<Movie> allMovies) {

    }

    @Override
    public void returnMovie(ArrayList<Movie> allMovies) {
        allMovies.remove(this);
        allMovies.add(AvailableMovie.create(this));

    }

    @Override
    public void addItselfToAvailableListOfMovieIfApplicable(ArrayList<Movie> availableMovies) {

    }

    @Override
    public void getAppropriateMessageOnCheckOutAction() {

    }

    @Override
    public void getAppropriateMessageOnReturnMovieAction() {
       System.out.println(Messages.RETURN_MOVIE_SUCCESSFUL);
    }

    public static CheckedOutMovies create(AvailableMovie availableMovie) {
        return new CheckedOutMovies(availableMovie.name, availableMovie.year, availableMovie.director, availableMovie.rating);
    }

}
