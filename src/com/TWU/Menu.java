package com.TWU;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    HashMap<Integer, String> menuList = new HashMap<>();

    public Menu() {
        menuList.put(1, "List Of Books");
    }

    @Override
    public String toString() {
        String mainMenu = "";
        for (Map.Entry m : menuList.entrySet()) {
            mainMenu += (m.getKey() + ". " + m.getValue());
        }
        return mainMenu;
    }
}
