package com.twu.books;

import com.twu.Messages;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class NullBookTest {

    @Test
    public void shouldNotBeAbleToAddItselfToAvailableListOfBooks() {
        ArrayList<Book> list = new ArrayList<>();
        NullBook nullBook = new NullBook("", "", 0, 0);

        nullBook.addItselfToAvailableListOfBookIfApplicable(list);

        assertFalse(list.contains(nullBook));
    }

    @Test
    public void shouldGiveMessageOnCheckout() {
        NullBook nullBook = new NullBook("", "", 0, 0);

        String actualOutput = nullBook.getAppropriateMessageOnCheckOutAction();
        String expectedOutput = Messages.CHECKOUT_UNSUCCESSFUL;

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void shouldGiveMessageOnReturning() {
        NullBook nullBook = new NullBook("", "", 0, 0);

        String actualOutput = nullBook.getAppropriateMessageOnReturnBookAction();
        String expectedOutput = Messages.RETURN_UNSUCCESSFUL;

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void shouldGiveMessageOnToString() {
        NullBook nullBook = new NullBook("", "", 0, 0);

        String actualOutput = nullBook.toString();
        String expectedOutput = Messages.BOOK_NOT_FOUND_IN_LIBRARY;

        assertEquals(expectedOutput, actualOutput);
    }
}