package com.twu.menu;

import com.twu.Library;
import com.twu.actions.ListBooksAction;
import com.twu.actions.QuitAction;
import com.twu.books.Book;
import com.twu.books.BooksView;
import com.twu.users.Customer;
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
public class CustomerMenuTest {

    @Mock
    BooksView booksViewStub;
    @Mock
    Library library;
    @Mock
    Customer user;

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
        CustomerMenu menuList = new CustomerMenu(this.menuList, mappedOptions);

        String actualOutput = menuList.toString();
        String expectedOutput = "\n1. List Of Books" + System.lineSeparator() + "2. Quit" + System.lineSeparator() + "Enter your choice:\n\n";

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void checkIfCorrectActionIsPerformed() {
        CustomerMenu menuList = new CustomerMenu(this.menuList, mappedOptions);

        menuList.performAction(1,user);
        ArrayList<Book> books = new ArrayList<>();
        Mockito.verify(library).getAvailableBooks(books);
    }

    @Test
    public void checkIfTheInputIsValid() {
        CustomerMenu menuList = new CustomerMenu(this.menuList, mappedOptions);

        boolean actualOutput = menuList.isValidInput(7);
        boolean expectedOutput = true;

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void checkIfTheInputIsInValid() {
        CustomerMenu menuList = new CustomerMenu(this.menuList, mappedOptions);

        boolean actualOutput = menuList.isValidInput(10);
        boolean expectedOutput = false;

        assertEquals(expectedOutput,actualOutput);
    }
}
