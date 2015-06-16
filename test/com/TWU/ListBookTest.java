package com.twu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ListBookTest {

    @Mock
    Library library;

    @Test
    public void shouldBeAbleToDisplayList() {
        BooksView booksViewStub = mock(BooksView.class);
        ArrayList<Book> book = new ArrayList<>();
        ListBooksAction listBook = new ListBooksAction(book, library);
        listBook.perform();

       verify(library).getAvailableBooks(book);
    }
}
