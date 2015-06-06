package com.TWU;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    @Test
    public void checkIfTheBookDetailsAreBeingRepresentedInOneLine() {
        String name = "Introduction to Algorithms";
        String author = "John";
        int year = 1920;
        Book book = new Book(name, author, year);

        String actualFormat = book.toString();
        String expectedFormat = "Introduction to Algorithms John 1920";

        assertEquals(actualFormat, expectedFormat);
    }
}
