package com.twu;

import com.twu.menu.CustomerMenu;
import com.twu.menu.LibrarianMenu;
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

    @Test
    public void shouldNotContinueLoopIfTheUserSelectsQuit() {

        MenuView menuViewStub = mock(MenuView.class);
        ConsoleOutput consoleOutputStub = mock(ConsoleOutput.class);
        CustomerMenu customerMenu = mock(CustomerMenu.class);
        when(loginController.login()).thenReturn(user);
        when(menuViewStub.takeUserInputForMainMenu()).thenReturn(8);
        EntryPoint entryPoint = new EntryPoint(menuViewStub, customerMenu, consoleOutputStub, loginController, librarianMenu);

        entryPoint.start();

        verify(menuViewStub).displayListOfMenu(customerMenu, user);
    }

    @Test
    public void shouldContinueLoopIfTheUserDoesNotSelectsQuit() {

        MenuView menuViewStub = mock(MenuView.class);
        when(loginController.login()).thenReturn(user);
        when(menuViewStub.takeUserInputForMainMenu()).thenReturn(6).thenReturn(8);
        CustomerMenu customerMenu = mock(CustomerMenu.class);
        ConsoleOutput consoleOutputStub = mock(ConsoleOutput.class);
        when(loginController.login()).thenReturn(user);
        EntryPoint entryPoint = new EntryPoint(menuViewStub, customerMenu, consoleOutputStub, loginController, librarianMenu);

        entryPoint.start();

        verify(menuViewStub, times(2)).displayListOfMenu(customerMenu, user);
    }

}