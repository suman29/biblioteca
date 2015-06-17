package com.twu.actions;

import com.twu.Option;
import com.twu.users.User;

public class QuitAction implements Option {
    @Override
    public void perform(User customer) {
        System.exit(1);
    }
}
