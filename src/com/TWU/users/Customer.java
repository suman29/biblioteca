package com.twu.users;

import com.twu.Messages;

public class Customer extends User {

    private String name;
    private String email;
    private String phoneNumber;

    public Customer(String libraryNumber, String password, String name, String email, String phoneNumber) {
        super(libraryNumber, password);
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getAppropriateMessageOnLogin() {
        return Messages.LOGIN_SUCCESSFUL;
    }

    public String toString() {
        return name + " " + email + " " + phoneNumber;
    }

}
