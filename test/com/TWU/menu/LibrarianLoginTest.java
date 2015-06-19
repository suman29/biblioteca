package com.twu.menu;

import com.twu.LoginController;
import com.twu.users.Customer;
import com.twu.users.Librarian;
import com.twu.users.NullUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
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
    @Mock
    Customer customer;
    @Mock
    NullUser nullUser;

    @Test
    public void shouldNotContinueLoopIfTheUserSelectsQuit() {
        when(loginController.login()).thenReturn(user);
        when(menuView.takeUserInputForMainMenu()).thenReturn(3);
        LibrarianLogin librarianLogin = new LibrarianLogin(loginController, menuView, librarianMenu, nullUser);

        librarianLogin.perform();

        verify(menuView).displayListOfMenu(librarianMenu, user);
    }

    @Test
    public void shouldContinueLoopIfTheUserDoesNotSelectsQuit() {
        when(loginController.login()).thenReturn(user);
        when(menuView.takeUserInputForMainMenu()).thenReturn(2).thenReturn(3);
        LibrarianLogin librarianLogin = new LibrarianLogin(loginController, menuView, librarianMenu, nullUser);

        librarianLogin.perform();

        verify(menuView, times(2)).displayListOfMenu(librarianMenu, user);
    }

    @Test
    public void shouldNotContinueFurtherIfItIsACustomer() {
        LibrarianLogin librarianLogin = new LibrarianLogin(loginController, menuView, librarianMenu, nullUser);
        when(loginController.login()).thenReturn(customer);
        librarianLogin.perform();

        verify(menuView, times(0)).displayListOfMenu(librarianMenu, user);

    }
}