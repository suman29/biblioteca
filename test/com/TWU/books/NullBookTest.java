package com.twu.books;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

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


    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }
}