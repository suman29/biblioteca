package com.twu;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    @Test
    public void shouldCheckOutABookWhenUserSelectsABook() {
        ArrayList<Book> booksAvailable = new ArrayList<>();
        ArrayList<Book> booksCheckedOut = new ArrayList<>();
        AvailableBook book1 = new AvailableBook("abc1", "xyz", 1908, 1);
        booksAvailable.add(book1);
        booksAvailable.add(new AvailableBook("abc2", "xyz", 1908, 2));
        booksAvailable.add(new AvailableBook("abc3", "xyz", 1908, 3));
        Library library = new Library(booksCheckedOut, booksAvailable);

        library.checkOutBook(book1);

        int actualOutput = booksCheckedOut.size();
        int expectedOutput = 0;

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void shouldBeAbleToAddReturnedBookWhenUserSelectsABook() {
        ArrayList<Book> booksCheckedOut = new ArrayList<>();
        ArrayList<Book> booksAvailable = new ArrayList<>();
        CheckedOutBook book1 = new CheckedOutBook("abc2", "xyz", 1908, 2);
        booksCheckedOut.add(new CheckedOutBook("abc1", "xyz", 1908, 1));
        booksCheckedOut.add(book1);
        booksCheckedOut.add(new CheckedOutBook("abc3", "xyz", 1908, 3));
        Library library = new Library(booksCheckedOut, booksAvailable);

        library.returnBook(book1);

        int actualOutput = booksAvailable.size();
        int expectedOutput = 0;

        assertEquals(expectedOutput, actualOutput);
    }

}