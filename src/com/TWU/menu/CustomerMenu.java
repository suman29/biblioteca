package com.twu.menu;

import com.twu.users.Customer;
import com.twu.users.User;

import java.util.HashMap;
import java.util.Map;

public class CustomerMenu {
    HashMap<Integer, String> menuList;
    HashMap<Integer, Option> mappedOptions;
    User user;

    public CustomerMenu(HashMap<Integer, String> menuList, HashMap<Integer, Option> mappedOptions, User user) {
        this.mappedOptions = mappedOptions;
        this.menuList = menuList;
        this.user = user;
    }

    public void performAction(int option) {
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
