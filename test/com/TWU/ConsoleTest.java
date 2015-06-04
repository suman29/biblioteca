package com.TWU;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class ConsoleTest {

    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void checkIfThereIsAWelcomeMessageBeingPrinted() {
        Console console = new Console();
        console.displayWelcomeMessage();

        String welcomeMsg = outputStream.toString();

        assertEquals(welcomeMsg, "Welcome" + System.lineSeparator());
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }
}


