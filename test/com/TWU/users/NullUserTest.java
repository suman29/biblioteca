package com.twu.users;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NullUserTest {

    @Test
    public void shouldBeEqualToAnyOtherNullUser() {
        NullUser nullUser = new NullUser("", "");

        assertEquals(nullUser, new NullUser("", ""));
    }
}