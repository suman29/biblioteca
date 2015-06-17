package com.twu.users;

import com.twu.Messages;

public class Customer extends User {

    public Customer(String libraryNumber, String password) {
        super(libraryNumber, password);
    }

    @Override
    public String getAppropriateMessageOnLogin() {
        return Messages.LOGIN_SUCCESSFUL;
    }
}
