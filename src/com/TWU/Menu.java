package com.twu;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    HashMap<Integer, String> menuList;
    HashMap<Integer, Option> mappedOptions;

    public Menu(BooksView booksView, HashMap<Integer, String> menuList, HashMap<Integer, Option> mappedOptions) {
        this.mappedOptions = mappedOptions;
        this.menuList = menuList;

    }

    public void performAction(int option) {
        mappedOptions.get(option).perform();
    }

    @Override
    public String toString() {
        String mainMenu = "";
        for (Map.Entry m : menuList.entrySet()) {
            mainMenu += (m.getKey() + ". " + m.getValue() + System.lineSeparator());
        }
        mainMenu += "Enter your choice:\n\n";
        return mainMenu;
    }

    public boolean isValidInput(int input) {
        return input >= 1 && input <= 3;
    }
}
