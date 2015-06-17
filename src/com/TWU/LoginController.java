package com.twu;

import com.twu.users.User;

public class LoginController {
    private LoginView loginView;
    private Authenticator authenticator;

    public LoginController(LoginView loginView, Authenticator authenticator) {
        this.loginView = loginView;
        this.authenticator = authenticator;
    }

    public void login() {
        String libraryNumber = loginView.getUserInput();
        String password = loginView.getUserInput();
        User user = authenticator.validateUser(libraryNumber,password);
    }
}
