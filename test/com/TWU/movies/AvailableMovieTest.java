package com.twu.movies;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class AvailableMovieTest {
    @Test
    public void shouldMakeItselfCheckedOutIfTheMovieIsCheckedOut() {
        AvailableMovie availableMovie = new AvailableMovie("movie1", 2014, "abc", 5);
        ArrayList<Movie> list = new ArrayList<>();
        list.add(availableMovie);
        availableMovie.checkOut(list);

        CheckedOutMovies checkedOutMovies = (CheckedOutMovies) list.get(list.indexOf(availableMovie));

        assertTrue(checkedOutMovies instanceof CheckedOutMovies);
    }

    @Test
    public void shouldBeAbleToAddItselfToListOfAvailableMovies() {
        ArrayList<Movie> list = new ArrayList<>();
        AvailableMovie availableMovie = new AvailableMovie("movie1", 2014, "abc", 5);

        availableMovie.addItselfToAvailableListOfMovieIfApplicable(list);

        assertTrue(list.contains(availableMovie));
    }
}