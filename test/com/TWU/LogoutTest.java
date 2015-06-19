package com.twu;

import com.twu.users.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LogoutTest {

    @Mock
    LoginController loginController;
    @Mock
    Customer customer;

    @Test
    public void shouldBeAbleToLogOutAUser() {
        Logout logout = new Logout(loginController);
        logout.perform(customer);

    }

    @Test
    public void shouldBeAbleToLogOut() {
        Logout logout = new Logout(loginController);
        logout.perform();
    }

}