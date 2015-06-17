package com.twu;

import com.twu.menu.Menu;
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

    @Test
    public void shouldNotContinueLoopIfTheUserSelectsQuit() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("4".getBytes());
        System.setIn(inputStream);
        MenuView menuViewStub = mock(MenuView.class);
        Menu menu = mock(Menu.class);
        ConsoleOutput consoleOutputStub = mock(ConsoleOutput.class);
        when(loginController.login()).thenReturn(user);
        EntryPoint entryPoint = new EntryPoint(menuViewStub, menu, consoleOutputStub, loginController);
        entryPoint.start();

        verify(menuViewStub).displayListOfMenu(menu,user);
    }

    @Test
    public void shouldContinueLoopIfTheUserDoesNotSelectsQuit() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("4".getBytes());
        System.setIn(inputStream);
        MenuView menuViewStub = mock(MenuView.class);
        Menu menu = mock(Menu.class);
        ConsoleOutput consoleOutputStub = mock(ConsoleOutput.class);
        when(loginController.login()).thenReturn(user);
        EntryPoint entryPoint = new EntryPoint(menuViewStub, menu, consoleOutputStub, loginController);
        entryPoint.start();

        verify(menuViewStub).displayListOfMenu(menu,user);
    }


}