package com.twu;

import com.twu.users.NullUser;
import com.twu.users.User;

public class LoginController {
    private LoginView loginView;
    private Authenticator authenticator;
    private NullUser nullUser;

    public LoginController(LoginView loginView, Authenticator authenticator, NullUser nullUser) {
        this.loginView = loginView;
        this.authenticator = authenticator;
        this.nullUser = nullUser;
    }

    public User login() {
        User user;
        do {
            loginView.displayPromptEnterLibraryNumber();
            String libraryNumber = loginView.getUserInput();
            loginView.displayPromptEnterPassword();
            String password = loginView.getUserInput();
            user = authenticator.validateUser(libraryNumber, password);
            loginView.displayMessage(user.getAppropriateMessageOnLogin());
        } while (nullUser.equals(user));
        return user;
    }
}
