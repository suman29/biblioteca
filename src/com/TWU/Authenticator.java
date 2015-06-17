package com.twu;

import com.twu.users.User;

import java.util.ArrayList;

public class Authenticator {
    ArrayList<User> allUsers;

    public Authenticator(ArrayList<User> allUsers) {
        this.allUsers = allUsers;
    }

    public User validateUser(User userToValidate) {
        return null;
    }
}
