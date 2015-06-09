package com.TWU;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuView {
    private BufferedReader br;

    public MenuView() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void displayListOfMenu(Menu menuList) {
        System.out.print(menuList.toString());
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

    public void errorMessage() {
        System.out.println("Select a valid option!");
    }
}
