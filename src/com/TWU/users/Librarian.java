package com.twu.users;

import com.twu.Messages;

public class Librarian extends User {
    public Librarian(String libraryNumber, String password) {
        super(libraryNumber, password);
    }

    @Override
    public String getAppropriateMessageOnLogin() {
        return Messages.LOGIN_SUCCESSFUL;
    }
}
