package com.TWU;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuView {
    BufferedReader br;

    public MenuView() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void displayListOfMenu(String menuString) {
        System.out.print(menuString);
    }
}
