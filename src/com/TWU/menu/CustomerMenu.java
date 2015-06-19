package com.twu.menu;

import com.twu.users.Customer;
import com.twu.users.User;

import java.util.HashMap;
import java.util.Map;

// It has the customer menu to be displayed to the customer.

public class CustomerMenu {
    HashMap<Integer, String> menuList;
    HashMap<Integer, Option> mappedOptions;

    public CustomerMenu(HashMap<Integer, String> menuList, HashMap<Integer, Option> mappedOptions) {
        this.mappedOptions = mappedOptions;
        this.menuList = menuList;
    }

    public void performAction(int option, User user) {
        mappedOptions.get(option).perform((Customer) user);
    }

    @Override
    public String toString() {
        String mainMenu = "\n";
        for (Map.Entry m : menuList.entrySet()) {
            mainMenu += (m.getKey() + ". " + m.getValue() + System.lineSeparator());
        }
        mainMenu += "Enter your choice:\n\n";
        return mainMenu;
    }

    public boolean isValidInput(int input) {
        return input >= 1 && input <= 9;
    }
}
