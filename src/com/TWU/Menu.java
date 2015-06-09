package com.TWU;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    HashMap<Integer, String> menuList = new HashMap<>();
    HashMap<Integer, Options> mappedOptions = new HashMap<>();

    public Menu() {
        menuList.put(1, "List Of Books");
    }

    @Override
    public String toString() {
        String mainMenu = "";
        for (Map.Entry m : menuList.entrySet()) {
            mainMenu += (m.getKey() + ". " + m.getValue());
        }
        mainMenu += "\nEnter your choice:";
        return mainMenu;
    }
}
