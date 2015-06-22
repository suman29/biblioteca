package com.twu.movies;

import com.twu.Messages;
import com.twu.users.Customer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NullMovieTest {

    String name = "ashray";
    String email = "123@yh.com";
    String number = "7205787250";

    @Test
    public void shouldDisplayAppropriateMessageOnCheckingOut() {
        NullMovie nullMovie = new NullMovie("", 0, "", 0, new Customer("", "", name, email, number));

        String actualOutput = nullMovie.getAppropriateMessageOnCheckOutAction();
        String expectedOutput = Messages.CHECKOUT_MOVIE_UNSUCCESSFUL;

        assertEquals(expectedOutput, actualOutput);
    }


    @Test
    public void shouldDisplayAppropriateMessageOnReturning() {
        NullMovie nullMovie = new NullMovie("", 0, "", 0, new Customer("", "", name, email, number));

        String actualOutput = nullMovie.getAppropriateMessageOnReturnMovieAction();
        String expectedOutput = Messages.RETURN_MOVIE_UNSUCCESSFUL;

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void shouldDisplayAppropriateMessageOnToString() {
        NullMovie nullMovie = new NullMovie("", 0, "", 0, new Customer("", "", name, email, number));

        String actualOutput = nullMovie.toString();
        String expectedOutput = Messages.MOVIE_NOT_FOUND;

        assertEquals(expectedOutput, actualOutput);
    }

}