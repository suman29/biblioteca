package com.twu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LogoutTest {
    @Mock
    LoginController loginController;

    @Test
    public void shouldBeAbleToLogOutAUser() {
        Logout logout = new Logout(loginController);
//        logout.perform(new Customer("", "", name, email, number));

//        verify(loginController).login();
    }

}