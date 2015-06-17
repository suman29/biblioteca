package com.twu;

import com.twu.users.User;

import java.util.Set;

public class Authenticator {
    Set<User> allUsers;

    public Authenticator(Set<User> allUsers) {
        this.allUsers = allUsers;
    }

    public User validateUser(User userToValidate) {
        if(allUsers.contains(userToValidate))
                return userToValidate;
        else
            return null;
    }
}
