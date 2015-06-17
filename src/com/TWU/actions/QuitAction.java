package com.twu.actions;

import com.twu.Option;
import com.twu.users.Customer;

public class QuitAction implements Option {
    @Override
    public void perform(Customer customer) {
        System.exit(1);
    }
}
