package com.twu.menu;

import com.twu.users.User;

public interface Option {
    void perform(User customer);

    void perform();
}
