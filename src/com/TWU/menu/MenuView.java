package com.twu.menu;

import com.twu.Messages;
import com.twu.users.User;

import java.io.BufferedReader;

// It handles input output for all the menus in this app.

public class MenuView {
    private BufferedReader br;

    public MenuView(BufferedReader br) {
        this.br = br;
    }

    public void displayListOfMenu(CustomerMenu menuList, User user) {
        System.out.print(menuList.toString());
    }


    public void displayListOfMenu(LibrarianMenu menuList, User user) {
        System.out.print(menuList.toString());
    }

    public void displayListOfMenu(MainMenu mainMenu) {
        System.out.print(mainMenu.toString());
    }

    public int takeUserInputForMainMenu() {
        try {
            int input = Integer.parseInt(br.readLine());
            if ((input > 0))
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
