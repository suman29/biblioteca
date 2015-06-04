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
        BookFileReader bookFileReaderStub = mock(BookFileReader.class);
        ArrayList<String> listOfBooks = new ArrayList<>();
        listOfBooks.add("Book 1");
        listOfBooks.add("Book 2");
        listOfBooks.add("Book 3");
        when(bookFileReaderStub.getListOfAvailableBooks())
                .thenReturn(listOfBooks);
        Library library = new Library(bookFileReaderStub);
        Console console = new Console();
        console.displayListOfBooks(library.getBooksAvailable());

        String actualOutput = outputStream.toString();
        String expectedOutput = "Book 1" + System.lineSeparator() +
                "Book 2" + System.lineSeparator() +
                "Book 3" + System.lineSeparator();

        assertThat(actualOutput, is(expectedOutput));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }
}