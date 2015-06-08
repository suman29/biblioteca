package com.TWU;

public class ConsoleOutput {

    public void displayWelcomeMessage() {
        System.out.println("Welcome");
    }

    public void displayListOfBooks(Books bookList) {
        System.out.print(bookList.toString());
    }

    public void displayMainMenu() {
        System.out.print(new Menu().toString());
    }

    public void displayWhenInvalidMainMenuIsSelected() {
        System.out.print("Select a valid option!");
    }
}