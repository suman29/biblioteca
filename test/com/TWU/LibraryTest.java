package com.twu;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    @Test
    public void shouldCheckOutABookWhenUserSelectsABook() {
        ArrayList<Book> booksAvailable = new ArrayList<>();
        ArrayList<Book> booksCheckedOut = new ArrayList<>();
        booksAvailable.add(new Book("abc", "xyz", 1908,1));
        booksAvailable.add(new Book("abc", "xyz", 1908,2));
        booksAvailable.add(new Book("abc", "xyz", 1908,3));
        Library library = new Library(booksCheckedOut, booksAvailable);

        int bookIndex = 2;
        library.checkOutBook(bookIndex);

        int actualOutput = booksCheckedOut.size();
        int expectedOutput = 1;

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void shouldBeAbleToAddReturnedBookWhenUserSelectsABook() {
        ArrayList<Book> booksCheckedOut = new ArrayList<>();
        ArrayList<Book> booksAvailable = new ArrayList<>();
        booksCheckedOut.add(new Book("abc", "xyz", 1908,1));
        booksCheckedOut.add(new Book("abc", "xyz", 1908,2));
        booksCheckedOut.add(new Book("abc", "xyz", 1908,3));
        Library library = new Library(booksCheckedOut, booksAvailable);

        int bookIndex = 2;
        library.returnBook(bookIndex);

        int actualOutput = booksAvailable.size();
        int expectedOutput = 1;

        assertEquals(expectedOutput, actualOutput);
    }

}