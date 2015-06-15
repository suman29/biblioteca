package com.twu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BooksViewTest {
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void shouldDisplayListOfBooks() {
        Books booksStub = mock(Books.class);
        ArrayList<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(new AvailableBook("Head First Java", "Kathy", 1995,1));
        listOfBooks.add(new AvailableBook("Learning C", "John", 2000,2));
        BooksView booksView = new BooksView(new Books(listOfBooks));
        booksView.displayListOfBooks();

        String expectedOutput = "1.  Head First Java                                   Kathy                         1995 " + System.lineSeparator() +
                "2.  Learning C                                        John                          2000 " + System.lineSeparator() + System.lineSeparator();
        when(booksStub.toString())
                .thenReturn(expectedOutput);
        String actualOutput = outputStream.toString();

        assertEquals(expectedOutput, actualOutput);
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }
}

