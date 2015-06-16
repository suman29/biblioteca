package com.twu.movies;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;

public class ReturnMovieViewTest {
    @Test
    public void shouldTakeUserInputToReturnAMovie() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Good".getBytes());
        System.setIn(byteArrayInputStream);
        InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ReturnMovieView returnMovieView = new ReturnMovieView(bufferedReader);

        String actualInput = returnMovieView.takeUserInputForReturningMovie();
        String expectedInput = "Good";

        assertEquals(expectedInput, actualInput);
    }

}