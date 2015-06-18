package com.twu.menu;

import com.twu.users.User;

// It is the interface created, which is implemented by all the actions in this app.

public interface Option {
    void perform(User customer);

    void perform();
}
