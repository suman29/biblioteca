package com.twu.views;

import com.twu.Library;
import com.twu.Messages;
import com.twu.actions.ListBooksAction;
import com.twu.actions.QuitAction;
import com.twu.books.Book;
import com.twu.menu.CustomerMenu;
import com.twu.menu.LibrarianMenu;
import com.twu.menu.MainMenu;
import com.twu.menu.Option;
import com.twu.views.BooksView;
import com.twu.users.Customer;
import com.twu.users.Librarian;
import com.twu.views.MenuView;
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
    @Mock
    Librarian librarian;
    @Mock
    Customer customer;

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
    public void shouldPrintTheCorrectMenuForCustomer() {
        CustomerMenu menuList = new CustomerMenu(this.menuList, mappedOptions);

        String menuString = "\n1. List Of Books" + System.lineSeparator() + "2. Quit" + System.lineSeparator() + "Enter your choice:" + System.lineSeparator() + System.lineSeparator();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("1".getBytes());
        InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        MenuView menuView = new MenuView(bufferedReader);
        menuView.displayListOfMenu(menuList, customer);

        assertEquals(menuString, outputStream.toString());
    }

    @Test
    public void shouldPrintTheCorrectMenuForLibrarian() {
        LibrarianMenu menuList = new LibrarianMenu(this.menuList, mappedOptions);

        String menuString = "\n1. List Of Books" + System.lineSeparator() + "2. Quit" + System.lineSeparator() + "Enter your choice:" + System.lineSeparator() + System.lineSeparator();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("1".getBytes());
        InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        MenuView menuView = new MenuView(bufferedReader);
        menuView.displayListOfMenu(menuList, librarian);

        assertEquals(menuString, outputStream.toString());
    }

    @Test
    public void shouldPrintTheCorrectMenuForMainMenu() {
        MainMenu menuList = new MainMenu(this.menuList, mappedOptions);

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

    @Test
    public void shouldDisplayAppropriateErrorMessage() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        MenuView menuView = new MenuView(bufferedReader);
        menuView.errorMessage();

        String actualInput = outputStream.toString();
        String expectedInput = Messages.ERROR_MESSAGE + System.lineSeparator();

        assertEquals(expectedInput, actualInput);
    }

    @Test
    public void shouldDisplayAppropriateMessageGiven() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        MenuView menuView = new MenuView(bufferedReader);
        menuView.displayMessage("hi");

        String actualInput = outputStream.toString();
        String expectedInput = "hi" + System.lineSeparator();

        assertEquals(expectedInput, actualInput);
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }
}
