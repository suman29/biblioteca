package com.twu.users;

import java.util.ArrayList;

// It is the app user, cab be of two types, customer or librarian.

public abstract class User {
    private String libraryNumber;
    private String password;

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    @Override
    public String toString() {
        return libraryNumber + System.lineSeparator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        User user = (User) o;

        if (libraryNumber != null ? !libraryNumber.equals(user.libraryNumber) : user.libraryNumber != null)
            return false;
        return !(password != null ? !password.equals(user.password) : user.password != null);

    }

    @Override
    public int hashCode() {
        int result = libraryNumber != null ? libraryNumber.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public abstract String getAppropriateMessageOnLogin();

    public void addToListIfCredentialsMatch(ArrayList<User> list, String libraryNumber, String password) {
        if (this.libraryNumber.equalsIgnoreCase(libraryNumber) && this.password.equalsIgnoreCase(password))
            list.add(this);
    }
}
