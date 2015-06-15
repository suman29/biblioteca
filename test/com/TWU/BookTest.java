package com.twu;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    @Test
    public void checkIfTheBookDetailsAreBeingRepresentedInOneLine() {
        String name = "Introduction to Algorithms";
        String author = "John";
        int year = 1920;
        int id = 1;
        Book book = new Book(name, author, year,id);

        String actualFormat = book.toString();
        String expectedFormat = "1.  Introduction to Algorithms                        John                          1920 ";

        assertEquals(actualFormat, expectedFormat);
    }
}
