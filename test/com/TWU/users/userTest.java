package com.twu.users;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class userTest {

    @Test
    public void shouldDisplayTheUserNumberProperly() {
        User user = new User("123-4567", "abcd");

        String actualOutput = user.toString();
        String expectedOutput = "123-4567" + System.lineSeparator();

        assertEquals(actualOutput,expectedOutput);
    }
}