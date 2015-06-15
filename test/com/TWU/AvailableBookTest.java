package com.twu;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class AvailableBookTest {
    @Test
    public void shouldBeAbleToAddItselfToListOfAvailableBooks() {
        ArrayList<Book> list = new ArrayList<>();
        AvailableBook availableBook = new AvailableBook("monster", "Ashray",2015,9);

        availableBook.addItselfToAvailableListOfBooksIfAppplicable(list);

        assertTrue(list.contains(availableBook));
    }

}