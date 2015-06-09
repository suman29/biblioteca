package com.TWU;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MenuViewTest {
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void shouldPrintTheCorrectMenu() {
        Menu menu = new Menu();

        String menuString = "1. List Of Books\nEnter your choice:";
        MenuView menuView = new MenuView();
        menuView.displayListOfMenu(menu);

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
