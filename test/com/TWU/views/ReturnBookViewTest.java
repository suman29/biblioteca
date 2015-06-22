package com.twu.views;

import com.twu.views.BooksView;
import com.twu.views.ReturnBookView;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.*;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ReturnBookViewTest {

    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

    @Mock
    BooksView booksView;

    @Test
    public void checkIfTheUserGivesAnIntegerInput() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("good".getBytes());
        System.setIn(byteArrayInputStream);
        InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ReturnBookView returnBookView = new ReturnBookView(bufferedReader, booksView);

        String actualInput = returnBookView.takeUserInputForReturningBook();
        String expectedInput = "good";

        assertEquals(expectedInput, actualInput);
    }

    @Test
    public void shouldBeAbleToDisplayList() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ReturnBookView returnBookView = new ReturnBookView(bufferedReader, booksView);
        returnBookView.displayListOfBooks();

        Mockito.verify(booksView).displayListOfBooks();
    }

    @Test
    public void shouldPrintMessageAfterBookBeingReturned() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ReturnBookView returnBookView = new ReturnBookView(bufferedReader, booksView);
        returnBookView.displayBookReturnedSuccessfully();

        String actualOutput = outputStream.toString();
        String expectedOutput = "Thank you for returning the book." + System.lineSeparator();

        assertEquals(expectedOutput, actualOutput);
    }


    @Test
    public void shouldPrintMessageAsGiven() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ReturnBookView returnBookView = new ReturnBookView(bufferedReader, booksView);
        returnBookView.displayMessage("hi");

        String actualOutput = outputStream.toString();
        String expectedOutput = "hi" + System.lineSeparator();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void shouldPrintMessageAfterBookBeingReturnedIsNotSuccessful() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ReturnBookView returnBookView = new ReturnBookView(bufferedReader, booksView);
        returnBookView.displayMessageWhenBookNotReturnedSuccessfully();

        String actualOutput = outputStream.toString();
        String expectedOutput = "That is not a valid book to return." + System.lineSeparator();

        assertEquals(expectedOutput, actualOutput);
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }

}