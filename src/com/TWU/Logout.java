package com.twu;

import com.twu.users.User;

public class Logout implements Option{
    private LoginController loginController;

    public Logout(LoginController loginController) {
        this.loginController = loginController;
    }

    @Override
    public void perform(User customer) {
        loginController.login();
    }
}
