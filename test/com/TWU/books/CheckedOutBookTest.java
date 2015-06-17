package com.twu.books;

import com.twu.users.Customer;
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
        CheckedOutBook checkedOutBook = new CheckedOutBook("monster", "Ashray", 2015, 9, new Customer("",""));

        checkedOutBook.addItselfToAvailableListOfBookIfApplicable(list);

        assertFalse(list.contains(checkedOutBook));
    }

    @Test
    public void shouldBeAbleToConvertAvailableBookToCheckedOutBook() {
        AvailableBook availableBook = new AvailableBook("God", "helpme", 2015, 10);
        CheckedOutBook checkoutBook = new CheckedOutBook("God", "helpme", 2015, 10, new Customer("",""));

        CheckedOutBook actualOutput = checkoutBook.create(availableBook, new Customer("",""));

        assertEquals(actualOutput, checkoutBook);
    }

    @Test
    public void shouldBeAbleToMakeItselfAvailableAfterTheBookIsReturned() {
        ArrayList<Book> list = new ArrayList<>();
        CheckedOutBook checkoutBook = new CheckedOutBook("God", "helpme", 2015, 10, new Customer("",""));
        list.add(checkoutBook);
        checkoutBook.returnBook(list);

        AvailableBook availableBook = (AvailableBook) list.get(list.indexOf(checkoutBook));

        assertTrue(availableBook instanceof AvailableBook);
    }

    @Test
    public void checkIfTheBookDetailsAreBeingRepresentedInOneLine() {
        String name = "Introduction to Algorithms";
        String author = "John";
        int year = 1920;
        int id = 1;
        Customer customer = new Customer("abc","123");
        Book book = new CheckedOutBook(name, author, year, id, customer);

        String actualFormat = book.toString();
        String expectedFormat = "1.  Introduction to Algorithms                        John                          1920  Customer:abc"+System.lineSeparator();

        assertEquals(actualFormat, expectedFormat);
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }
}