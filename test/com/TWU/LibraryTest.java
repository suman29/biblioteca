package com.TWU;

import com.TWU.Utils.BookFileReader;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LibraryTest {

    @Test
    public void checkIfBooksAvailableIsNotNullWhenOperated() {
        ArrayList<String> books = new ArrayList<>();
        books.add("Book 1");
        books.add("Book 2");
        books.add("Book 3");

        Library library = new Library(books);

        ArrayList<String> actualListOfAvailableBooks = library.getBooksAvailable();
        assertThat(actualListOfAvailableBooks, is(notNullValue()));

    }
}