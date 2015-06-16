package com.twu.movies;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;

public class CheckOutMovieViewTest {
    @Test
    public void shouldTakeUserInputToCheckOutAMovie() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Good".getBytes());
        System.setIn(byteArrayInputStream);
        InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        CheckOutMovieView checkOutMovieView = new CheckOutMovieView(bufferedReader);

        String actualInput = checkOutMovieView.takeUserInputForCheckOutMovie();
        String expectedInput = "Good";

        assertEquals(expectedInput, actualInput);
    }

}