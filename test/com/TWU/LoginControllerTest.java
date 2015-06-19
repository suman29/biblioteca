package com.twu;

import com.twu.users.Customer;
import com.twu.users.NullUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

    @Mock
    LoginView loginView;

    @Mock
    Authenticator authenticator;

    @Mock
    NullUser nullUser;

    @Mock
    Customer customer;


    @Test
    public void shouldBeAbleToPerformValidUserAction() {
        LoginController loginController = new LoginController(loginView, authenticator, nullUser);

        when(authenticator.validateUser(null, null))
                .thenReturn(customer);
        loginController.login();

        verify(loginView, times(2)).getUserInput();
    }

    @Test
    public void shouldNotExitWhileLoopIfItsNotAValidUser() {
        NullUser user1 = new NullUser("", "");
        when(authenticator.validateUser(null, null))
                .thenReturn(customer);
        LoginController loginController = new LoginController(loginView, authenticator, user1);

        loginController.login();

        verify(loginView, times(2)).getUserInput();
    }

    @Test
    public void shouldExitWhileLoopIfItIsAValidUser() {
        NullUser user1 = new NullUser("", "");
        String name = "ashray";
        String email = "123@yh.com";
        String number = "7205787250";
        when(authenticator.validateUser(null, null))
                .thenReturn(new Customer("Number", "Password", name, email, number));
        LoginController loginController = new LoginController(loginView, authenticator, user1);


        loginController.login();

        verify(loginView, times(2)).getUserInput();
    }
}