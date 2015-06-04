package com.TWU;

import java.util.ArrayList;

public class Console {

    public void displayWelcomeMessage() {
        System.out.println("Welcome");
    }

    public void displayListOfBooks(ArrayList<String> bookList) {
        for (String book : bookList) {
            System.out.println(book);
        }
    }
}