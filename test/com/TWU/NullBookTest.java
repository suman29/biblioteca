package com.twu;

import com.twu.books.Book;
import com.twu.books.NullBook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class NullBookTest {
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void shouldNotBeAbleToAddItselfToAvailableListOfBooks() {
        ArrayList<Book> list = new ArrayList<>();
        NullBook nullBook = new NullBook("", "", 0, 0);

        nullBook.addItselfToAvailableListOfBookIfApplicable(list);

        assertFalse(list.contains(nullBook));
    }

    @Test
    public void shouldDisplayAppropriateMessageOnCheckingOut() {
        NullBook nullBook = new NullBook("", "", 0, 0);
        nullBook.getAppropriateMessageOnCheckOutAction();

        String actualOutput = outputStream.toString();
        String expectedOutput = Messages.CHECKOUT_UNSUCCESSFUL + System.lineSeparator();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void shouldDisplayAppropriateMessageOnReturning() {
        NullBook nullBook = new NullBook("", "", 0, 0);
        nullBook.getAppropriateMessageOnReturnBookAction();

        String actualOutput = outputStream.toString();
        String expectedOutput = Messages.RETURN_UNSUCCESSFUL + System.lineSeparator();

        assertEquals(expectedOutput, actualOutput);
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }
}