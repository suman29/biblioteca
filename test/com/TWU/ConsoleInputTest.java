package com.TWU;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class ConsoleInputTest {

    @Test
    public void checkIfTheUserGivesAnIntegerInput() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("1".getBytes());
        System.setIn(byteArrayInputStream);
        ConsoleInput consoleInput = new ConsoleInput();

        int actualInput = consoleInput.takeUserInputForMainMenu();
        int expectedInput = 1;

        assertEquals(expectedInput, actualInput);
    }

    @Test
    public void checkIfTheUserGivesSomeInvalidInputInTheMainMenu() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("0".getBytes());
        System.setIn(byteArrayInputStream);
        ConsoleInput consoleInput = new ConsoleInput();

        int actualInput = consoleInput.takeUserInputForMainMenu();
        int expectedInput = 0;

        assertEquals(expectedInput, actualInput);
    }
}