package com.twu.books;

import com.twu.books.AvailableBook;
import com.twu.books.Book;
import com.twu.books.Books;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BooksTest {

    @Test
    public void checkIfTheBooksDetailsAreBeingRepresentedInProperFormat() {
        ArrayList<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(new AvailableBook("Head First Java", "Kathy", 1995, 1));
        listOfBooks.add(new AvailableBook("Learning C", "John", 2000, 2));
        Books books = new Books(listOfBooks);

        String expectedFormat = books.toString();
        String actualFormat = "1.  Head First Java                                   Kathy                         1995 " + System.lineSeparator() +
                "2.  Learning C                                        John                          2000 " + System.lineSeparator() + System.lineSeparator();

        assertEquals(expectedFormat, actualFormat);
    }
}