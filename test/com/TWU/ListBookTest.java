package com.TWU;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;

public class ListBookTest {

    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void shouldBeAbleToDisplayList() {
        BooksView booksViewStub = mock(BooksView.class);
        ListBooks listBook = new ListBooks(booksViewStub);
        listBook.perform();

        Mockito.verify(booksViewStub).displayListOfBooks();
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }
}
