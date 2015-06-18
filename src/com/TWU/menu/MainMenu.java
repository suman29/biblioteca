package com.twu.menu;

import java.util.HashMap;
import java.util.Map;

public class MainMenu {
    HashMap<Integer, String> menuList;
    HashMap<Integer, MainOption> mappedOptions;

    public MainMenu(HashMap<Integer, String> menuList, HashMap<Integer, MainOption> mappedOptions) {
        this.menuList = menuList;
        this.mappedOptions = mappedOptions;
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

}
