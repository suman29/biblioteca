package com.twu;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaSetUpTest {
    @Test
    public void shouldNotContinueLoopIfTheUserSelectsQuit() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("2".getBytes());
        System.setIn(inputStream);
        MenuView menuViewStub = mock(MenuView.class);
        Menu menu = mock(Menu.class);
        ConsoleOutput consoleOutputStub = mock(ConsoleOutput.class);

        BibliotecaSetUp bibliotecaSetUp = new BibliotecaSetUp(menuViewStub, menu,1, consoleOutputStub);
        bibliotecaSetUp.start();

        verify(menuViewStub).displayListOfMenu(menu);
    }

}