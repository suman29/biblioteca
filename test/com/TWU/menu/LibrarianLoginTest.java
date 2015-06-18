package com.twu.menu;

import com.twu.LoginController;
import com.twu.users.Librarian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LibrarianLoginTest {
    @Mock
    LibrarianMenu librarianMenu;
    @Mock
    LoginController loginController;
    @Mock
    MenuView menuView;
    @Mock
    Librarian user;

    @Test
    public void shouldNotContinueLoopIfTheUserSelectsQuit() {
        when(loginController.login()).thenReturn(user);
        when(menuView.takeUserInputForMainMenu()).thenReturn(3);
        LibrarianLogin librarianLogin = new LibrarianLogin(loginController, menuView, librarianMenu);

        librarianLogin.perform();

        verify(menuView).displayListOfMenu(librarianMenu, user);
    }

}