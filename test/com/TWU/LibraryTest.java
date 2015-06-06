package com.TWU;

import org.junit.Test;

import java.util.ArrayList;

public class LibraryTest {

    @Test(expected = UnsupportedOperationException.class)
    public void checkIfBooksAvailableIsNotModifiable() {
        ArrayList<String> books = new ArrayList<>();
        books.add("Book 1");
        books.add("Book 2");
        books.add("Book 3");

        Library library = new Library(books);
        library.getBooksAvailable().add("book 3");
    }
}