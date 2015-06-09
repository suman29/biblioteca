package com.TWU;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class MenuTest {

    @Test
    public void checkIfMenuIsRepresentedProperly() {
        BooksView booksViewStub = mock(BooksView.class);
        Menu menuList = new Menu(booksViewStub);

        String actualOutput = menuList.toString();
        String expectedOutput = "1. List Of Books" + System.lineSeparator() + "2. Quit" + System.lineSeparator()+"Enter your choice:";

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void checkIfCorrectActionIsPerformed() {
        BooksView booksViewStub = mock(BooksView.class);
        Menu menuList = new Menu(booksViewStub);

        menuList.performAction(1);
        Mockito.verify(booksViewStub).displayListOfBooks();
    }
}
