package com.twu;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CheckedOutBookTest {

    @Test
    public void shouldNotBeAbleToAddItselfToAvailableListOfBooks() {
        ArrayList<Book> list = new ArrayList<>();
        CheckedOutBook checkedOutBook = new CheckedOutBook("monster", "Ashray", 2015, 9);

        checkedOutBook.addItselfToAvailableListOfBooksIfAppplicable(list);

        assertFalse(list.contains(checkedOutBook));
    }

    @Test
    public void shouldBeAbleToConvertAvailableBookToCheckedOutBook() {
        AvailableBook availableBook = new AvailableBook("God", "helpme", 2015, 10);
        CheckedOutBook checkoutBook = new CheckedOutBook("God", "helpme", 2015, 10);

        CheckedOutBook actualOutput = checkoutBook.create(availableBook);

        assertEquals(actualOutput, checkoutBook);
    }
}