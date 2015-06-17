package com.twu.users;

public class User {
    private String libraryNumber;
    private String password;

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    @Override
    public String toString(){
        return libraryNumber+System.lineSeparator();
    }
}
