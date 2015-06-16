package com.twu;

import java.io.BufferedReader;

public class MenuView {
    private BufferedReader br;

    public MenuView(BufferedReader br) {
        this.br = br;
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
        } catch (Exception e) {
            return -1;
        }
    }

    public void errorMessage() {
        System.out.println(Messages.ERROR_MESSAGE);
    }
}
