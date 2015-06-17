package com.twu.users;

import com.twu.Messages;

public class NullUser extends User {
    public NullUser(String libraryNumber, String password) {
        super(libraryNumber, password);
    }

    @Override
    public String getAppropriateMessageOnLogin() {
        return Messages.LOGIN_UNSUCCESSFUL;
    }

    @Override
    public boolean equals(Object o) {
        return o != null && getClass() == o.getClass();
    }
}
