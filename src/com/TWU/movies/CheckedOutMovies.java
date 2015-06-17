package com.twu.movies;

import com.twu.Messages;
import com.twu.users.Customer;

import java.util.ArrayList;

public class CheckedOutMovies extends Movie {
    private Customer customer;

    public CheckedOutMovies(String name, int year, String director, int rating, Customer customer) {
        super(name, year, director, rating);
        this.customer = customer;
    }

    @Override
    public void checkOut(ArrayList<Movie> allMovies, Customer customer) {

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
    public String getAppropriateMessageOnCheckOutAction() {
        return (Messages.MOVIE_ALREADY_CHECKED);

    }

    @Override
    public String getAppropriateMessageOnReturnMovieAction() {
       return (Messages.RETURN_MOVIE_SUCCESSFUL);

    }

    public String toString(){
     return (String.format("%-50s", name) + String.format("%-30s", director) + String.format("%-5s", year) + "rating: " + rating+" customer:"+customer.toString());
    }

    public static CheckedOutMovies create(AvailableMovie availableMovie, Customer customer) {
        return new CheckedOutMovies(availableMovie.name, availableMovie.year, availableMovie.director, availableMovie.rating, customer);
    }

}
