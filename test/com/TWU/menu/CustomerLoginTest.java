package com.twu.menu;

import com.twu.LoginController;
import com.twu.users.Customer;
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

    @Test
    public void shouldNotContinueLoopIfTheUserSelectsQuit() {
        when(loginController.login()).thenReturn(user);
        when(menuView.takeUserInputForMainMenu()).thenReturn(8);
        CustomerLogin customerLogin = new CustomerLogin(loginController, menuView, customerMenu);

        customerLogin.perform();

        verify(menuView).displayListOfMenu(customerMenu, user);
    }

}