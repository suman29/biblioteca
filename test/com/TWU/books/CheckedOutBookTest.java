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
    String name = "ashray";
    String email = "123@yh.com";
    String number="7205787250";
    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void shouldNotBeAbleToAddItselfToAvailableListOfBooks() {
        ArrayList<Book> list = new ArrayList<>();
        CheckedOutBook checkedOutBook = new CheckedOutBook("monster", "Ashray", 2015, 9, new Customer("", "", name, email, number));

        checkedOutBook.addItselfToAvailableListOfBookIfApplicable(list);

        assertFalse(list.contains(checkedOutBook));
    }

    @Test
    public void shouldBeAbleToConvertAvailableBookToCheckedOutBook() {
        AvailableBook availableBook = new AvailableBook("God", "helpme", 2015, 10);
        CheckedOutBook checkoutBook = new CheckedOutBook("God", "helpme", 2015, 10, new Customer("", "", name, email, number));

        CheckedOutBook actualOutput = checkoutBook.create(availableBook, new Customer("", "", name, email, number));

        assertEquals(actualOutput, checkoutBook);
    }

    @Test
    public void shouldBeAbleToMakeItselfAvailableAfterTheBookIsReturned() {
        ArrayList<Book> list = new ArrayList<>();
        CheckedOutBook checkoutBook = new CheckedOutBook("God", "helpme", 2015, 10, new Customer("", "", name, email, number));
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
        Customer customer = new Customer("abc", "123", "ab","mn", "pq");
        Book book = new CheckedOutBook(name, author, year, id, customer);

        String actualFormat = book.toString();
        String expectedFormat = "1.  Introduction to Algorithms                        John                          1920  Customer:ab mn pq";

        assertEquals(actualFormat, expectedFormat);
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }
}