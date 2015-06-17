package com.twu.movies;

import com.twu.Messages;
import com.twu.users.Customer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NullMovieTest {

    @Test
    public void shouldDisplayAppropriateMessageOnCheckingOut() {
        NullMovie nullMovie = new NullMovie("", 0, "", 0, new Customer("",""));

        String actualOutput =  nullMovie.getAppropriateMessageOnCheckOutAction();
        String expectedOutput = Messages.CHECKOUT_MOVIE_UNSUCCESSFUL;

        assertEquals(expectedOutput, actualOutput);
    }


    @Test
    public void shouldDisplayAppropriateMessageOnReturning() {
        NullMovie nullMovie = new NullMovie("", 0, "", 0, new Customer("",""));

        String actualOutput = nullMovie.getAppropriateMessageOnReturnMovieAction();
        String expectedOutput = Messages.RETURN_MOVIE_UNSUCCESSFUL ;

        assertEquals(expectedOutput, actualOutput);
    }

}