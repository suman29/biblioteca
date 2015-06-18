package com.twu.actions;

import com.twu.menu.Option;
import com.twu.users.User;

// Display the details of the customers.

public class CustomerDetailsAction implements Option {
    @Override
    public void perform(User customer) {
        System.out.println(customer.toString());
    }

    @Override
    public void perform() {

    }
}
