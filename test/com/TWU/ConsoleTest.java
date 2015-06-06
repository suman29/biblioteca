package com.TWU;

import com.TWU.Utils.BookFileReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    @Test
    public void checkThatTheListOfBooksIsPrinted() throws Exception {
        Books booksStub = mock(Books.class);
        ArrayList<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(new Book("Head First Java", "Kathy", 1995));
        listOfBooks.add(new Book("Learning C", "John", 2000));
        Console console = new Console();
        console.displayListOfBooks(new Books(listOfBooks));

        String expectedOutput = "Head First Java Kathy 1995" + System.lineSeparator() +
                "Learning C John 2000" + System.lineSeparator();
        when(booksStub.toString())
                .thenReturn(expectedOutput);
        String actualOutput = outputStream.toString();

        assertEquals(actualOutput, expectedOutput);
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }
}