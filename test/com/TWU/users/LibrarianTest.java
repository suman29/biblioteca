package com.twu.users;

import com.twu.Messages;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibrarianTest {

    @Test
    public void shouldDisplayAppropriateMessageOnLogin() {
        Librarian librarian = new Librarian("abc", "dfd");

        String actualOutput = librarian.getAppropriateMessageOnLogin();
        String expectedOutput = Messages.LOGIN_SUCCESSFUL;

        assertEquals(expectedOutput, actualOutput);
    }
}

