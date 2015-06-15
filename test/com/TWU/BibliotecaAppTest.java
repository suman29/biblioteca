package com.twu;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaAppTest {
    @Test
    public void shouldNotContinueLoopIfTheUserSelectsQuit() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("4".getBytes());
        System.setIn(inputStream);
        MenuView menuViewStub = mock(MenuView.class);
        Menu menu = mock(Menu.class);
        ConsoleOutput consoleOutputStub = mock(ConsoleOutput.class);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(menuViewStub, menu, consoleOutputStub);
        bibliotecaApp.start();

        verify(menuViewStub).displayListOfMenu(menu);
    }

    @Test
    public void shouldContinueLoopIfTheUserDoesNotSelectsQuit() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("4".getBytes());
        System.setIn(inputStream);
        MenuView menuViewStub = mock(MenuView.class);
        Menu menu = mock(Menu.class);
        ConsoleOutput consoleOutputStub = mock(ConsoleOutput.class);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(menuViewStub, menu, consoleOutputStub);
        bibliotecaApp.start();

        verify(menuViewStub).displayListOfMenu(menu);
        verify(menuViewStub).displayListOfMenu(menu);
    }


}