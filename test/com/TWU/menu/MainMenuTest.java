package com.twu.menu;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class MainMenuTest {

    HashMap<Integer, String> menuList;
    HashMap<Integer, MainOption> mappedOptions;

    @Before
    public void setUp() throws Exception {
        menuList = new HashMap<>();
        mappedOptions = new HashMap<>();
        menuList.put(1, "List Of Books");
        menuList.put(2, "Quit");
    }

    @Test
    public void shouldDisplayMainMenu(){
        MainMenu mainMenu = new MainMenu(menuList,mappedOptions);

        String actualOutput = mainMenu.toString();
        String expectedOutput = "\n1. List Of Books" + System.lineSeparator() + "2. Quit" + System.lineSeparator() + "Enter your choice:\n\n";

        assertEquals(expectedOutput, actualOutput);
    }
}