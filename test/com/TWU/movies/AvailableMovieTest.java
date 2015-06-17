package com.twu.movies;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class AvailableMovieTest {

    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

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

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }
}