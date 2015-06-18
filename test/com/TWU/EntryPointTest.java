package com.twu;

import com.twu.menu.LibrarianMenu;
import com.twu.menu.MainMenu;
import com.twu.menu.MenuView;
import com.twu.users.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EntryPointTest {

    @Mock
    LoginController loginController;
    @Mock
    Customer user;
    @Mock
    LibrarianMenu librarianMenu;
    @Mock
    MainMenu mainMenu;

    @Test
    public void shouldNotContinueLoopIfTheUserSelectsQuit() {

        MenuView menuViewStub = mock(MenuView.class);
        ConsoleOutput consoleOutputStub = mock(ConsoleOutput.class);
        when(menuViewStub.takeUserInputForMainMenu()).thenReturn(5);
        when(mainMenu.isValidInput(5)).thenReturn(true);
        EntryPoint entryPoint = new EntryPoint(menuViewStub, consoleOutputStub, mainMenu);

        entryPoint.start();

        verify(mainMenu).performAction(5);
    }

    @Test
    public void shouldContinueLoopIfTheUserDoesNotSelectsQuit() {

        MenuView menuViewStub = mock(MenuView.class);
        ConsoleOutput consoleOutputStub = mock(ConsoleOutput.class);
        when(menuViewStub.takeUserInputForMainMenu()).thenReturn(4).thenReturn(5);
        when(mainMenu.isValidInput(5)).thenReturn(true);
        when(mainMenu.isValidInput(4)).thenReturn(true);
        EntryPoint entryPoint = new EntryPoint(menuViewStub, consoleOutputStub, mainMenu);

        entryPoint.start();

        verify(mainMenu).performAction(4);
    }

}