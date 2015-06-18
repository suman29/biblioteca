package com.twu.menu;

import java.util.HashMap;
import java.util.Map;

// It is the main menu of the app, where all users can log in.

public class MainMenu {
    HashMap<Integer, String> menuList;
    HashMap<Integer, Option> mappedOptions;

    public MainMenu(HashMap<Integer, String> menuList, HashMap<Integer, Option> mappedOptions) {
        this.menuList = menuList;
        this.mappedOptions = mappedOptions;
    }

    public void performAction(int option) {
        mappedOptions.get(option).perform();
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
        return input >= 0 && input <= 5;
    }
}
