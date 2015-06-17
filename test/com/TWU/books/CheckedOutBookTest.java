package com.twu.books;

import com.twu.books.AvailableBook;
import com.twu.books.Book;
import com.twu.books.CheckedOutBook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class CheckedOutBookTest {

    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void shouldNotBeAbleToAddItselfToAvailableListOfBooks() {
        ArrayList<Book> list = new ArrayList<>();
        CheckedOutBook checkedOutBook = new CheckedOutBook("monster", "Ashray", 2015, 9);

        checkedOutBook.addItselfToAvailableListOfBookIfApplicable(list);

        assertFalse(list.contains(checkedOutBook));
    }

    @Test
    public void shouldBeAbleToConvertAvailableBookToCheckedOutBook() {
        AvailableBook availableBook = new AvailableBook("God", "helpme", 2015, 10);
        CheckedOutBook checkoutBook = new CheckedOutBook("God", "helpme", 2015, 10);

        CheckedOutBook actualOutput = checkoutBook.create(availableBook);

        assertEquals(actualOutput, checkoutBook);
    }

    @Test
    public void shouldBeAbleToMakeItselfAvailableAfterTheBookIsReturned() {
        ArrayList<Book> list = new ArrayList<>();
        CheckedOutBook checkoutBook = new CheckedOutBook("God", "helpme", 2015, 10);
        list.add(checkoutBook);
        checkoutBook.returnBook(list);

        AvailableBook availableBook = (AvailableBook) list.get(list.indexOf(checkoutBook));

        assertTrue(availableBook instanceof AvailableBook);
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }
}