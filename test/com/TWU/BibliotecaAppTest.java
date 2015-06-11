package com.TWU;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaAppTest {

    @Test
    public void shouldNotContinueLoopIfTheUserSelectsQuit() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("2".getBytes());
        System.setIn(inputStream);
        MenuView menuViewStub = mock(MenuView.class);
        Menu menu = mock(Menu.class);
        Books booksStub = mock(Books.class);
        ConsoleOutput consoleOutputStub = mock(ConsoleOutput.class);

        BibliotecaApp app = new BibliotecaApp(booksStub, consoleOutputStub);
        app.start();

        verify(menuViewStub).displayListOfMenu(menu);
    }
}