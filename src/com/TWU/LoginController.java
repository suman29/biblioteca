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
        loginView.displayPromptEnterLibraryNumber();
        String libraryNumber = loginView.getUserInput();
        loginView.displayPromptEnterPassword();
        String password = loginView.getUserInput();
        User user = authenticator.validateUser(libraryNumber,password);
    }
}
