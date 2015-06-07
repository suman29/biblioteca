package com.TWU;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BooksTest {

    @Test
    public void checkIfTheBooksDetailsAreBeingRepresentedInProperFormat() {
        ArrayList<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(new Book("Head First Java", "Kathy", 1995));
        listOfBooks.add(new Book("Learning C", "John", 2000));
        Books books = new Books(listOfBooks);

        String expectedFormat = books.toString();
        String actualFormat = "Head First Java                                   Kathy                         1995 " + System.lineSeparator() +
                "Learning C                                        John                          2000 " + System.lineSeparator();

        assertEquals(expectedFormat, actualFormat);
    }
}