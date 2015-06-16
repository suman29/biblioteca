package com.twu.movies;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class CheckedOutMoviesTest {

    @Test
    public void shouldMakeItselfAvailableAfterTheMovieIsReturned() {
        CheckedOutMovies checkoutMovie = new CheckedOutMovies("movie1", 2014, "abc", 5);
        ArrayList<Movie> list = new ArrayList<>();
        list.add(checkoutMovie);

        checkoutMovie.returnMovie(list);

        AvailableMovie availableMovie = (AvailableMovie) list.get(list.indexOf(checkoutMovie));

        assertTrue(availableMovie instanceof AvailableMovie);
    }

}