package com.twu;

import com.twu.users.Customer;
import com.twu.users.User;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class AuthenticatorTest {

    @Test
    public void shouldValidTheCredentialsByTheUser() {
        Customer user1 = new Customer("abc","xyz");
        Customer user2 = new Customer("123","xyz");
        Set<User> allUser = new HashSet<>();
        allUser.add(user1);
        allUser.add(user2);
        Authenticator authenticator = new Authenticator(allUser);

        User actualUser = authenticator.validateUser(user1);

        assertEquals(user1, actualUser);
    }
}