package com.twu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ConsoleOutputTest {

    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void checkIfThereIsAWelcomeMessageBeingPrinted() {
        ConsoleOutput consoleOutput = new ConsoleOutput();
        consoleOutput.displayWelcomeMessage();

        String welcomeMsg = outputStream.toString();

        assertEquals(welcomeMsg, "Welcome" + System.lineSeparator());
    }

    @Test
    public void checkIfUserDoesNotGivesAValidInputThenMessageIsPrinted() {
        ConsoleOutput consoleOutput = new ConsoleOutput();
        consoleOutput.displayWhenInvalidMainMenuIsSelected();

        String actualOutput = outputStream.toString();
        String expectedOutput = "Select a valid option!";

        assertEquals(expectedOutput, actualOutput);
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }
}