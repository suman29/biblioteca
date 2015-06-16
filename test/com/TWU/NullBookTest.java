package com.twu;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;

public class NullBookTest {
    @Test
    public void shouldNotBeAbleToAddItselfToAvailableListOfBooks() {
        ArrayList<Book> list = new ArrayList<>();
        NullBook nullBook = new NullBook("", "", 0, 0);

        nullBook.addItselfToAvailableListOfBooksIfApplicable(list);

        assertFalse(list.contains(nullBook));
    }
}