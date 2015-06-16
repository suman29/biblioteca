package com.twu.movies;

import com.twu.Messages;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
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

    @Test
    public void shouldDisplayAppropriateMessageOnCheckingOut() {
        AvailableMovie availableMovie = new AvailableMovie("movie1", 2014, "abc", 5);
        availableMovie.getAppropriateMessageOnCheckOutAction();

        String actualOutput = outputStream.toString();
        String expectedOutput = Messages.CHECKOUT_MOVIE_SUCCESSFUL + System.lineSeparator();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void shouldDisplayAppropriateMessageOnReturningMovie() {
        AvailableMovie availableMovie = new AvailableMovie("movie1", 2014, "abc", 5);
        availableMovie.getAppropriateMessageOnReturnMovieAction();

        String actualOutput = outputStream.toString();
        String expectedOutput = Messages.MOVIE_ALREADY_AVAILABLE;

        assertEquals(expectedOutput, actualOutput);
    }


    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }
}