package com.twu;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MenuTest {

    @Mock
    BooksView booksViewStub;
    @Mock
    Library library;

    HashMap<Integer, String> menuList;
    HashMap<Integer, Option> mappedOptions;

    @Before
    public void setUp() throws Exception {
        menuList = new HashMap<>();
        mappedOptions = new HashMap<>();
        menuList.put(1, "List Of Books");
        menuList.put(2, "Quit");
        ArrayList<Book> availableBooks = new ArrayList<>();
        mappedOptions.put(1, new ListBooksAction(availableBooks, library));
        mappedOptions.put(2, new QuitAction());

    }

    @Test
    public void checkIfMenuIsRepresentedProperly() {
        Menu menuList = new Menu(this.menuList, mappedOptions);

        String actualOutput = menuList.toString();
        String expectedOutput = "\n1. List Of Books" + System.lineSeparator() + "2. Quit" + System.lineSeparator() + "Enter your choice:\n\n";

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void checkIfCorrectActionIsPerformed() {
        Menu menuList = new Menu(this.menuList, mappedOptions);

        menuList.performAction(1);
        ArrayList<Book> books = new ArrayList<>();
        Mockito.verify(library).getAvailableBooks(books);
    }
}
