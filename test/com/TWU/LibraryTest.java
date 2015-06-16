package com.twu;

import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

public class LibraryTest {

    @Mock
    AvailableBook availableBook;

    @Mock
    CheckedOutBook checkedOutBook;

    @Test
    public void shouldCheckOutABookWhenUserSelectsABook() {
        ArrayList<Book> booksAvailable = new ArrayList<>();
        ArrayList<Book> booksCheckedOut = new ArrayList<>();
        AvailableBook book1 = new AvailableBook("abc1", "xyz", 1908, 1);
        booksAvailable.add(book1);
        booksAvailable.add(new AvailableBook("abc2", "xyz", 1908, 2));
        booksAvailable.add(new AvailableBook("abc3", "xyz", 1908, 3));
        Library library = new Library(booksAvailable);

        library.checkOutBook(book1);

        verify(checkedOutBook).create(book1);
    }

    @Test
    public void shouldBeAbleToAddReturnedBookWhenUserSelectsABook() {
        ArrayList<Book> booksCheckedOut = new ArrayList<>();
        ArrayList<Book> booksAvailable = new ArrayList<>();
        CheckedOutBook book1 = new CheckedOutBook("abc2", "xyz", 1908, 2);
        booksCheckedOut.add(new CheckedOutBook("abc1", "xyz", 1908, 1));
        booksCheckedOut.add(book1);
        booksCheckedOut.add(new CheckedOutBook("abc3", "xyz", 1908, 3));
        Library library = new Library(booksAvailable);

        library.returnBook(book1);

        int actualOutput = booksAvailable.size();
        int expectedOutput = 1;

        assertEquals(expectedOutput, actualOutput);
    }

}