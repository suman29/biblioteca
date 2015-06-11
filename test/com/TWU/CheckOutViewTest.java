package com.twu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class CheckOutViewTest {
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void checkIfTheUserGivesAnIntegerInput() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("1".getBytes());
        System.setIn(byteArrayInputStream);
        InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        CheckOutView checkOutView = new CheckOutView(bufferedReader);

        int actualInput = checkOutView.takeUserInputForCheckOutBook();
        int expectedInput = 1;

        assertEquals(expectedInput, actualInput);
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }

}