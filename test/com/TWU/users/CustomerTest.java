package com.twu.users;

import com.twu.Messages;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    @Test
    public void shouldDisplayAppropriateMessageOnLogin() {
       Customer customer = new Customer("abc","dfd","df","fdf","dffe");

        String actualOutput = customer.getAppropriateMessageOnLogin();
        String expectedOutput = Messages.LOGIN_SUCCESSFUL;

        assertEquals(expectedOutput, actualOutput);
    }
}