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

    public int takeUserInputForMainMenu() {
        try {
            int input = Integer.parseInt(br.readLine());
            if (input > 0)
                return input;
            else
                return -1;
        } catch (IOException e) {
            return -1;
        }
    }
}
