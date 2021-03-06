package com.twu.menu;

import com.twu.LoginController;
import com.twu.users.Customer;
import com.twu.users.NullUser;
import com.twu.views.MenuView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerLoginTest {

    @Mock
    CustomerMenu customerMenu;
    @Mock
    LoginController loginController;
    @Mock
    MenuView menuView;
    @Mock
    Customer user;
    @Mock
    NullUser nullUser;

    @Test
    public void shouldNotContinueLoopIfTheUserSelectsQuit() {
        when(loginController.login()).thenReturn(user);
        when(menuView.takeUserInputForMainMenu()).thenReturn(9);
        CustomerLogin customerLogin = new CustomerLogin(loginController, menuView, customerMenu, nullUser);

        customerLogin.perform();

        verify(menuView).displayListOfMenu(customerMenu, user);
    }

    @Test
    public void shouldContinueLoopIfTheUserDoesNotSelectsQuit() {
        when(loginController.login()).thenReturn(user);
        when(menuView.takeUserInputForMainMenu()).thenReturn(7).thenReturn(9);
        CustomerLogin customerLogin = new CustomerLogin(loginController, menuView, customerMenu, nullUser);

        customerLogin.perform();

        verify(menuView, times(2)).displayListOfMenu(customerMenu, user);
    }

}