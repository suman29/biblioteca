package com.twu.users;

import com.twu.Messages;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NullUserTest {

    @Test
    public void shouldBeEqualToAnyOtherNullUser() {
        NullUser nullUser = new NullUser("", "");

        assertEquals(nullUser, new NullUser("", ""));
    }

    @Test
    public void shouldDisplayMessageOnLogin() {
        NullUser nullUser = new NullUser("", "");

        assertEquals(nullUser.getAppropriateMessageOnLogin(), Messages.LOGIN_UNSUCCESSFUL);
    }
}