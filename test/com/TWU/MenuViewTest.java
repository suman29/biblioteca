package com.TWU;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MenuViewTest {
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }
    @Test
    public void shouldPrintTheCorrectMenu() {
        String menuString = "1.List Of Books\nEnter the choice:\n";
        MenuView menuView = new MenuView();
        menuView.displayListOfMenu(menuString);

        assertEquals(menuString, outputStream.toString());
    }

    @Test
    public void checkIfTheUserGivesAnIntegerInput() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("1".getBytes());
        System.setIn(byteArrayInputStream);
        ConsoleInput consoleInput = new ConsoleInput();

        int actualInput = consoleInput.takeUserInputForMainMenu();
        int expectedInput = 1;

        assertEquals(expectedInput, actualInput);
    }
}
