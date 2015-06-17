package com.twu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

    @Mock
    LoginView loginView;

    @Mock
    Authenticator authenticator;


    @Test
    public void shouldBeAbleToPerformValidUserAction() {
        LoginController loginController = new LoginController(loginView, authenticator);
        loginController.login();

        verify(loginView,times(2)).getUserInput();
    }

}