package com.twu.books;

import com.twu.Messages;
import com.twu.users.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AvailableBookTest {

    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    String name = "ashray";
    String email = "123@yh.com";
    String number = "7205787250";

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void shouldBeAbleToAddItselfToListOfAvailableBooks() {
        ArrayList<Book> list = new ArrayList<>();
        AvailableBook availableBook = new AvailableBook("monster", "Ashray", 2015, 9);

        availableBook.addItselfToAvailableListOfBookIfApplicable(list);

        assertTrue(list.contains(availableBook));
    }

    @Test
    public void shouldBeAbleToConvertAvailableBookToCheckedOutBook() {
        AvailableBook availableBook = new AvailableBook("God", "helpme", 2015, 10);
        CheckedOutBook checkoutBook = new CheckedOutBook("God", "helpme", 2015, 10, new Customer("", "", name, email, number));

        AvailableBook actualOutput = availableBook.create(checkoutBook);

        assertEquals(actualOutput, checkoutBook);
    }

    @Test
    public void shouldBeAbleToCheckoutItself() {
        ArrayList<Book> list = new ArrayList<>();
        AvailableBook availableBook = new AvailableBook("god", "helpme", 2013, 1);
        list.add(availableBook);
        availableBook.checkOut(list, new Customer("", "", name, email, number));

        CheckedOutBook checkedOutBook = (CheckedOutBook) list.get(list.indexOf(availableBook));

        assertTrue(checkedOutBook instanceof CheckedOutBook);
    }

    @Test
    public void shouldGiveMessageOnCheckout() {
        AvailableBook availableBook = new AvailableBook("god", "helpme", 2013, 1);

        String actualOutput = availableBook.getAppropriateMessageOnCheckOutAction();
        String expectedOutput = Messages.CHECKOUT_SUCCESSFUL;

        assertEquals(expectedOutput, actualOutput);
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }

}