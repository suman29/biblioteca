package com.twu;

import com.twu.menu.Option;
import com.twu.users.User;

// It allows user to logout.

public class Logout implements Option {
    private LoginController loginController;

    public Logout(LoginController loginController) {
        this.loginController = loginController;
    }

    @Override
    public void perform(User customer) {

    }

    @Override
    public void perform() {

    }
}
