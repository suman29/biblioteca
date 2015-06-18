package com.twu.menu;

import com.twu.LoginController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MainMenuTest {

    HashMap<Integer, String> menuList;
    HashMap<Integer, MainOption> mappedOptions;

    @Mock
    LoginController loginController;
    @Mock
    MenuView menuView;
    @Mock
    CustomerMenu customerMenu;
    @Mock
    LibrarianMenu librarianMenu;
    @Mock
    CustomerLogin customerLogin;


    @Before
    public void setUp() throws Exception {
        menuList = new HashMap<>();
        mappedOptions = new HashMap<>();
        menuList.put(1, "Customer login");
        menuList.put(2, "Librarian login");
        mappedOptions.put(1, new CustomerLogin(loginController, menuView,customerMenu));
        mappedOptions.put(2, new LibrarianLogin(loginController, menuView,librarianMenu));
    }

    @Test
    public void shouldDisplayMainMenu() {
        MainMenu mainMenu = new MainMenu(menuList, mappedOptions);

        String actualOutput = mainMenu.toString();
        String expectedOutput = "\n1. Customer login" + System.lineSeparator() + "2. Librarian login" + System.lineSeparator() + "Enter your choice:\n\n";

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void shouldPerformActionOnCorrectInput() {
        MainMenu mainMenu = new MainMenu(menuList,mappedOptions);
        when(menuView.takeUserInputForMainMenu()).thenReturn(8);
        mainMenu.performAction(1);

        verify(loginController).login();
    }
}