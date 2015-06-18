package com.twu.actions;

import com.twu.menu.Option;
import com.twu.users.User;

// It helps to quit the app.

public class QuitAction implements Option {
    @Override
    public void perform(User customer) {
        System.exit(1);
    }

    @Override
    public void perform() {

    }
}
