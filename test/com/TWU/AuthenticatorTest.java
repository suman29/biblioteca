package com.twu;

import com.twu.users.Customer;
import com.twu.users.NullUser;
import com.twu.users.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class AuthenticatorTest {

    @Test
    public void shouldValidTheCredentialsByTheUser() {
        String name = "ashray";
        String email = "123@yh.com";
        String number = "7205787250";
        Customer user1 = new Customer("abc", "xyz", name, email, number);
        Customer user2 = new Customer("123", "xyz", name, email, number);
        Set<User> allUser = new HashSet<>();
        allUser.add(user1);
        allUser.add(user2);
        NullUser nullUser = new NullUser("", "");
        ArrayList<User> list = new ArrayList<>();
        Authenticator authenticator = new Authenticator(allUser, nullUser, list);


        User actualUser = authenticator.validateUser("123", "xyz");

        assertEquals(user2, actualUser);
    }
}