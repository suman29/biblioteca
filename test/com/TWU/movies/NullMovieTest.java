package com.twu.movies;

import com.twu.Messages;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class NullMovieTest {

    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void shouldDisplayAppropriateMessageOnCheckingOut() {
        NullMovie nullMovie = new NullMovie("", 0, "", 0);
        nullMovie.getAppropriateMessageOnCheckOutAction();

        String actualOutput = outputStream.toString();
        String expectedOutput = Messages.CHECKOUT_MOVIE_UNSUCCESSFUL + System.lineSeparator();

        assertEquals(expectedOutput, actualOutput);
    }


    @Test
    public void shouldDisplayAppropriateMessageOnReturning() {
        NullMovie nullMovie = new NullMovie("", 0, "", 0);
        nullMovie.getAppropriateMessageOnReturnMovieAction();

        String actualOutput = outputStream.toString();
        String expectedOutput = Messages.RETURN_MOVIE_UNSUCCESSFUL + System.lineSeparator();

        assertEquals(expectedOutput, actualOutput);
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }

}