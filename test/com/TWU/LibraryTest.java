package com.twu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class LibraryTest {

    @Mock
    AvailableBook availableBook;

    @Mock
    CheckedOutBook checkedOutBook;

    @Test
    public void shouldCheckOutABookWhenUserSelectsABook() {
        ArrayList<Book> booksAvailable = new ArrayList<>();
        AvailableBook book1 = new AvailableBook("abc1", "xyz", 1908, 1);
        booksAvailable.add(book1);
        booksAvailable.add(new AvailableBook("abc2", "xyz", 1908, 2));
        booksAvailable.add(new AvailableBook("abc3", "xyz", 1908, 3));
        Library library = new Library(booksAvailable);

        library.checkOutBook(availableBook);

        verify(availableBook).checkOut(booksAvailable);
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

    @Test
    public void shouldBeABleToDisplayOnlyTheAvailableBooks() {
        ArrayList<Book> allBooks = new ArrayList<>();
        allBooks.add(new AvailableBook("abc2", "xyz", 1908, 2));
        allBooks.add(new AvailableBook("abc3", "xyz", 1908, 3));
        allBooks.add(new CheckedOutBook("abc2", "xyz", 1908, 2));
        allBooks.add(new CheckedOutBook("abc1", "xyz", 1908, 1));
        Library library = new Library(allBooks);
        ArrayList<Book> booksAvailable = new ArrayList<>();
        booksAvailable.add(new AvailableBook("abc2", "xyz", 1908, 2));
        booksAvailable.add(new AvailableBook("abc3", "xyz", 1908, 3));

        ArrayList<Book> abc = new ArrayList<>();

        ArrayList<Book> expectedOutput =booksAvailable;
        ArrayList<Book> actualOutput = library.getAvailableBooks(abc);

        assertEquals(expectedOutput,actualOutput);

    }

}