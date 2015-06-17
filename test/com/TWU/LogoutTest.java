package com.twu;

import com.twu.users.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LogoutTest {
    @Mock
    LoginController loginController;

    @Test
    public void shouldBeAbleToLogOutAUser() {
        Logout logout = new Logout(loginController);
        logout.perform(new Customer("", ""));

        verify(loginController).login();
    }

}