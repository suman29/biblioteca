package com.twu;

import com.twu.users.Customer;
import com.twu.users.User;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class AuthenticatorTest {


    public void shouldValidTheCredentialsByTheUser() {
        Customer user1 = mock(Customer.class);
        Customer user2 = mock(Customer.class);
        ArrayList<User> allUser = new ArrayList<>();
        allUser.add(user1);
        allUser.add(user2);
        Authenticator authenticator = new Authenticator(allUser);
        when(user1.equals(user2))
                .thenReturn(true);

        User actualUser = authenticator.validateUser(user1);
        User expectedUser = user1;


    }
}