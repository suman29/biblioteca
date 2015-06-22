package com.twu.views;

import com.twu.views.LibrarianActionView;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class LibrarianActionViewTest {
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void shouldTakeUserInputToGetDetailsOfTheCheckOutItem() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Good".getBytes());
        System.setIn(byteArrayInputStream);
        InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        LibrarianActionView librarianActionView = new LibrarianActionView(bufferedReader);

        String actualInput = librarianActionView.takeUserInputToGetDetailsOfItem();
        String expectedInput = "Good";

        assertEquals(expectedInput, actualInput);
    }

    @Test
    public void shouldPrintMessageAsGiven() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        LibrarianActionView librarianActionView = new LibrarianActionView(bufferedReader);
        librarianActionView.displayMessage("hi");

        String actualOutput = outputStream.toString();
        String expectedOutput = "hi" + System.lineSeparator();

        assertEquals(expectedOutput, actualOutput);
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }

}