package com.twu.users;

import com.twu.Messages;

// It is a user who uses the app, get the details of the checked out items.

public class Librarian extends User {
    public Librarian(String libraryNumber, String password) {
        super(libraryNumber, password);
    }

    @Override
    public String getAppropriateMessageOnLogin() {
        return Messages.LOGIN_SUCCESSFUL;
    }
}
