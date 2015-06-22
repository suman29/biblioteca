package com.twu.views;

import com.twu.views.CheckOutMovieView;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class CheckOutMovieViewTest {
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

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

    @Test
    public void shouldPrintMessageAsGiven() {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        CheckOutMovieView checkOutMovieView = new CheckOutMovieView(bufferedReader);
        checkOutMovieView.displayMessage("hi");

        String actualInput = outputStream.toString();
        String expectedInput = "hi" + System.lineSeparator();

        assertEquals(expectedInput, actualInput);
    }


    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }

}