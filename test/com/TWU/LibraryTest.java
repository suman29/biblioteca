package com.TWU;

import org.junit.Test;

import java.util.ArrayList;

public class LibraryTest {

    @Test(expected = UnsupportedOperationException.class)
    public void checkIfBooksAvailableIsNotModifiable() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Head First Java", "Kathy", 1995));
        books.add(new Book("Head First Java", "Kathy", 1995));
        books.add(new Book("Head First Java", "Kathy", 1995));

        Library library = new Library(books);
        library.getBooksAvailable().add(new Book("Head First Java", "Kathy", 1995));
    }
}