package com.twu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class MenuViewTest {
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    HashMap<Integer, String> menuList;
    HashMap<Integer, Option> mappedOptions;

    @Mock
    BooksView booksViewStub;


    @Before
    public void setUp() throws Exception {
        menuList = new HashMap<>();
        mappedOptions = new HashMap<>();
        menuList.put(1, "List Of Books");
        menuList.put(2, "Quit");
        mappedOptions.put(1, new ListBooks(booksViewStub));
        mappedOptions.put(2, new QuitOption());
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void shouldPrintTheCorrectMenu() {
        Menu menuList = new Menu(booksViewStub,this.menuList,mappedOptions);

        String menuString = "1. List Of Books" + System.lineSeparator() + "2. Quit" + System.lineSeparator() + "Enter your choice:";
        MenuView menuView = new MenuView();
        menuView.displayListOfMenu(menuList);

        assertEquals(menuString, outputStream.toString());
    }

    @Test
    public void checkIfTheUserGivesAnIntegerInput() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("1".getBytes());
        System.setIn(byteArrayInputStream);
        MenuView menuView = new MenuView();

        int actualInput = menuView.takeUserInputForMainMenu();
        int expectedInput = 1;

        assertEquals(expectedInput, actualInput);
    }


    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }
}
