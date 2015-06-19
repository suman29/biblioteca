package com.twu.movies;

import com.twu.Messages;
import com.twu.users.Customer;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AvailableMovieTest {

    @Test
    public void shouldMakeItselfCheckedOutIfTheMovieIsCheckedOut() {
        AvailableMovie availableMovie = new AvailableMovie("movie1", 2014, "abc", 5);
        String name = "ashray";
        String email = "123@yh.com";
        String number = "7205787250";
        ArrayList<Movie> list = new ArrayList<>();
        list.add(availableMovie);
        availableMovie.checkOut(list, new Customer("", "", name, email, number));

        CheckedOutMovie checkedOutMovie = (CheckedOutMovie) list.get(list.indexOf(availableMovie));

        assertTrue(checkedOutMovie instanceof CheckedOutMovie);
    }

    @Test
    public void shouldBeAbleToAddItselfToListOfAvailableMovies() {
        ArrayList<Movie> list = new ArrayList<>();
        AvailableMovie availableMovie = new AvailableMovie("movie1", 2014, "abc", 5);

        availableMovie.addItselfToAvailableListOfMovieIfApplicable(list);

        assertTrue(list.contains(availableMovie));
    }

    @Test
    public void shouldDisplayAppropriateMessageOnReturning() {
        AvailableMovie availableMovie = new AvailableMovie("movie1", 2014, "abc", 5);

        String actualOutput = availableMovie.getAppropriateMessageOnReturnMovieAction();
        String expectedOutput = Messages.MOVIE_ALREADY_AVAILABLE;

        assertEquals(expectedOutput, actualOutput);
    }
}