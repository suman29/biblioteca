package com.twu;

import com.twu.users.NullUser;
import com.twu.users.User;

import java.util.Set;

public class Authenticator {
    private Set<User> allUsers;
    private NullUser nullUser;

    public Authenticator(Set<User> allUsers, NullUser nullUser) {
        this.allUsers = allUsers;
        this.nullUser = nullUser;
    }

    public User validateUser(User userToValidate) {
        if(allUsers.contains(userToValidate))
                return userToValidate;
        else
            return nullUser;
    }
}
