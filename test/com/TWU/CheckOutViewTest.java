package com.twu;

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
public class CheckOutViewTest {
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

    @Mock
    BooksView booksView;

    @Test
    public void checkIfTheUserGivesAStringInput() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Good".getBytes());
        System.setIn(byteArrayInputStream);
        InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        CheckOutView checkOutView = new CheckOutView(bufferedReader, booksView);

        String actualInput = checkOutView.takeUserInputForCheckOutBook();
        String expectedInput = "Good";

        assertEquals(expectedInput, actualInput);
    }

    @Test
    public void shouldBeAbleToDisplayList() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        CheckOutView checkOutView = new CheckOutView(bufferedReader, booksView);
        checkOutView.displayListOfBooks();

        Mockito.verify(booksView).displayListOfBooks();
    }

    @Test
    public void shouldPrintSuccessfulMessageAfterBookBeingCheckedOut() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        CheckOutView checkOutView = new CheckOutView(bufferedReader, booksView);
        checkOutView.displayBookCheckedOutSuccessfully();

        String actualOutput = outputStream.toString();
        String expectedOutput = "Thank you! Enjoy the book" + System.lineSeparator();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void shouldPrintMessageAfterBookBeingNotCheckedOut() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        CheckOutView checkOutView = new CheckOutView(bufferedReader, booksView);
        checkOutView.displayBookNotCheckedOutSuccessfully();

        String actualOutput = outputStream.toString();
        String expectedOutput = "That book is not available." + System.lineSeparator();

        assertEquals(expectedOutput, actualOutput);
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }

}