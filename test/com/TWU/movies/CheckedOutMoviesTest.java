package com.twu.movies;

import com.twu.Messages;
import com.twu.users.Customer;
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
    String name = "ashray";
    String email = "123@yh.com";
    String number="7205787250";
    Customer customer = new Customer("", "", name, email, number);

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void shouldMakeItselfAvailableAfterTheMovieIsReturned() {
        CheckedOutMovies checkoutMovie = new CheckedOutMovies("movie1", 2014, "abc", 5, customer);
        ArrayList<Movie> list = new ArrayList<>();
        list.add(checkoutMovie);

        checkoutMovie.returnMovie(list);

        AvailableMovie availableMovie = (AvailableMovie) list.get(list.indexOf(checkoutMovie));

        assertTrue(availableMovie instanceof AvailableMovie);
    }

    @Test
    public void shouldDisplayMessageWhenMovieIsReturnedSuccessfully() {
        CheckedOutMovies checkoutMovie = new CheckedOutMovies("movie1", 2014, "abc", 5, customer);

        String actualOutput = checkoutMovie.getAppropriateMessageOnReturnMovieAction();
        String expectedOutput = Messages.RETURN_MOVIE_SUCCESSFUL;

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void shouldDisplayMessageWhenMovieIsAlreadyCheckedOut() {
        CheckedOutMovies checkoutMovie = new CheckedOutMovies("movie1", 2014, "abc", 5, customer);

        String actualOutput = checkoutMovie.getAppropriateMessageOnCheckOutAction();
        String expectedOutput = Messages.MOVIE_ALREADY_CHECKED;

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void shouldRepresentMovieInProperFormat() {
        Movie movie = new CheckedOutMovies("Movie1", 2001, "abc", 1, new Customer("abc", "", "ab","mn","pq"));

        String actualOutput = movie.toString();
        String expectedOutput = "Movie1                                            abc                           2001 rating: 1 customer:ab mn pq";

        assertEquals(expectedOutput, actualOutput);
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }

}