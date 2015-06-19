package com.twu.menu;

import com.twu.users.Librarian;

import java.util.HashMap;
import java.util.Map;

// It has the librarian menu to be displayed when librarian logs in .

public class LibrarianMenu {
    HashMap<Integer, String> menuListLibrarian;
    HashMap<Integer, Option> mappedOptionsLibrarian;

    public LibrarianMenu(HashMap<Integer, String> menuListLibrarian, HashMap<Integer, Option> mappedOptionsLibrarian) {
        this.mappedOptionsLibrarian = mappedOptionsLibrarian;
        this.menuListLibrarian = menuListLibrarian;
    }

    public void performAction(int option, Librarian librarian) {
        mappedOptionsLibrarian.get(option).perform(librarian);
    }

    @Override
    public String toString() {
        String mainMenu = "\n";
        for (Map.Entry m : menuListLibrarian.entrySet()) {
            mainMenu += (m.getKey() + ". " + m.getValue() + System.lineSeparator());
        }
        mainMenu += "Enter your choice:\n\n";
        return mainMenu;
    }

    public boolean isValidInput(int input) {
        return input >= 1 && input <= 4;
    }
}
