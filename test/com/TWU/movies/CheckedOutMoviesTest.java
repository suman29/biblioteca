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

public class CheckedOutMoviesTest {

    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void shouldMakeItselfAvailableAfterTheMovieIsReturned() {
        CheckedOutMovies checkoutMovie = new CheckedOutMovies("movie1", 2014, "abc", 5);
        ArrayList<Movie> list = new ArrayList<>();
        list.add(checkoutMovie);

        checkoutMovie.returnMovie(list);

        AvailableMovie availableMovie = (AvailableMovie) list.get(list.indexOf(checkoutMovie));

        assertTrue(availableMovie instanceof AvailableMovie);
    }

    @Test
    public void shouldDisplayMessageWhenMovieIsReturnedSuccessfully() {
        CheckedOutMovies checkoutMovie = new CheckedOutMovies("movie1", 2014, "abc", 5);

        String actualOutput = checkoutMovie.getAppropriateMessageOnReturnMovieAction();
        String expectedOutput = Messages.RETURN_MOVIE_SUCCESSFUL ;

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void shouldDisplayMessageWhenMovieIsAlreadyCheckedOut() {
        CheckedOutMovies checkoutMovie = new CheckedOutMovies("movie1", 2014, "abc", 5);

        String actualOutput = checkoutMovie.getAppropriateMessageOnCheckOutAction();
        String expectedOutput = Messages.MOVIE_ALREADY_CHECKED ;

        assertEquals(expectedOutput, actualOutput);
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }

}