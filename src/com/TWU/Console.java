package com.TWU;

import java.util.ArrayList;
import java.util.List;

public class Console {

    public void displayWelcomeMessage() {
        System.out.println("Welcome");
    }

    public void displayListOfBooks(List<String> bookList) {
        for (String book : bookList) {
            System.out.println(book);
        }
    }
}