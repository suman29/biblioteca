package com.TWU;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
    public void checkThatTheListOfBooksIsPrinted() throws Exception {
        Books booksStub = mock(Books.class);
        ArrayList<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(new Book("Head First Java", "Kathy", 1995));
        listOfBooks.add(new Book("Learning C", "John", 2000));
        ConsoleOutput consoleOutput = new ConsoleOutput();
        consoleOutput.displayListOfBooks(new Books(listOfBooks));

        String expectedOutput = "Head First Java                                   Kathy                         1995 " + System.lineSeparator() +
                "Learning C                                        John                          2000 " + System.lineSeparator();
        when(booksStub.toString())
                .thenReturn(expectedOutput);
        String actualOutput = outputStream.toString();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void checkIfTheMainMenuIsPrinted() {
        ConsoleOutput consoleOutput = new ConsoleOutput();
        consoleOutput.displayMainMenu();

        String actualOutput = outputStream.toString();
        String expectedOutput = "1. List Books";

        assertEquals(expectedOutput, actualOutput);
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