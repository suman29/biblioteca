package com.TWU;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

public class ListBookTest {

    @Test
    public void shouldBeAbleToDisplayList() {
        BooksView booksViewStub = mock(BooksView.class);
        ListBooks listBook = new ListBooks(booksViewStub);
        listBook.perform();

        Mockito.verify(booksViewStub).displayListOfBooks();
    }
}
