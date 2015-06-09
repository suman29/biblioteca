package com.TWU;

import java.util.ArrayList;

public class BibliotecaApp {
    ConsoleInput consoleInput;
    ConsoleOutput consoleOutput;
    ArrayList<Book> initialBookList;

    public BibliotecaApp() {
        initialBookList = new ArrayList<>();
        initialBookList.add(new Book("Lets C", "Yashwant", 1990));
        initialBookList.add(new Book("Head First Java", "Kathy", 1993));
        initialBookList.add(new Book("Learn Java", "John", 2000));
        consoleInput = new ConsoleInput();
        consoleOutput = new ConsoleOutput();
    }

    public void start() {
        consoleOutput.displayWelcomeMessage();
        consoleOutput.displayMainMenu();
        consoleInput.takeUserInputForMainMenu();
        consoleOutput.displayListOfBooks(new Books(initialBookList));
    }

    public static void main(String args[]){
        BibliotecaApp app = new BibliotecaApp();
        app.start();
    }
}
