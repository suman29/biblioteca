package com.twu.menu;

import com.twu.Library;
import com.twu.Option;
import com.twu.actions.ListBooksAction;
import com.twu.actions.QuitAction;
import com.twu.books.Book;
import com.twu.books.BooksView;
import com.twu.menu.Menu;
import com.twu.menu.MenuView;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class MenuViewTest {
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    HashMap<Integer, String> menuList;
    HashMap<Integer, Option> mappedOptions;

    @Mock
    BooksView booksViewStub;
    @Mock
    Library library;

    @Before
    public void setUp() throws Exception {
        menuList = new HashMap<>();
        mappedOptions = new HashMap<>();
        menuList.put(1, "List Of Books");
        menuList.put(2, "Quit");
        ArrayList<Book> availableBooks = new ArrayList<>();
        mappedOptions.put(1, new ListBooksAction(availableBooks, library));
        mappedOptions.put(2, new QuitAction());
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void shouldPrintTheCorrectMenu() {
        Menu menuList = new Menu(this.menuList, mappedOptions);

        String menuString = "\n1. List Of Books" + System.lineSeparator() + "2. Quit" + System.lineSeparator() + "Enter your choice:" + System.lineSeparator() + System.lineSeparator();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("1".getBytes());
        InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        MenuView menuView = new MenuView(bufferedReader);
        menuView.displayListOfMenu(menuList);

        assertEquals(menuString, outputStream.toString());
    }

    @Test
    public void checkIfTheUserGivesAnIntegerInput() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("1".getBytes());
        System.setIn(byteArrayInputStream);
        InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        MenuView menuView = new MenuView(bufferedReader);

        int actualInput = menuView.takeUserInputForMainMenu();
        int expectedInput = 1;

        assertEquals(expectedInput, actualInput);
    }


    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }
}
