package com.twu.librarianActions;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;

public class LibrarianActionViewTest {
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

}