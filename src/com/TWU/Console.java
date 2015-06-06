package com.TWU;

public class Console {

    public void displayWelcomeMessage() {
        System.out.println("Welcome");
    }

    public void displayListOfBooks(Books bookList) {
        System.out.print(bookList.toString());
    }

}