package com.twu;

import com.twu.menu.CustomerMenu;
import com.twu.menu.LibrarianMenu;
import com.twu.menu.MenuView;
import com.twu.users.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EntryPointTest {

    @Mock
    LoginController loginController;

    @Mock
    User user;

    @Mock
    LibrarianMenu librarianMenu;

    @Test
    public void shouldNotContinueLoopIfTheUserSelectsQuit() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("4".getBytes());
        System.setIn(inputStream);
        MenuView menuViewStub = mock(MenuView.class);
        CustomerMenu customerMenu = mock(CustomerMenu.class);
        ConsoleOutput consoleOutputStub = mock(ConsoleOutput.class);
        when(loginController.login()).thenReturn(user);
        EntryPoint entryPoint = new EntryPoint(menuViewStub, customerMenu, consoleOutputStub, loginController, librarianMenu);
        entryPoint.start();

        verify(menuViewStub).displayListOfMenu(customerMenu,user);
    }

    @Test
    public void shouldContinueLoopIfTheUserDoesNotSelectsQuit() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("4".getBytes());
        System.setIn(inputStream);
        MenuView menuViewStub = mock(MenuView.class);
        CustomerMenu customerMenu = mock(CustomerMenu.class);
        ConsoleOutput consoleOutputStub = mock(ConsoleOutput.class);
        when(loginController.login()).thenReturn(user);
        EntryPoint entryPoint = new EntryPoint(menuViewStub, customerMenu, consoleOutputStub, loginController, librarianMenu);
        entryPoint.start();

        verify(menuViewStub).displayListOfMenu(customerMenu,user);
    }


}