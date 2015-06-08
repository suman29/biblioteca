package com.TWU;

import java.util.ArrayList;

public class BibliotecaApp {
    ConsoleInput consoleInput;
    ConsoleOutput consoleOutput;
    ArrayList<Book> initialBookList;

    public BibliotecaApp() {
        initialBookList = new ArrayList<>();
        initialBookList.add(new Book("book1", "author1", 1920));
        initialBookList.add(new Book("book1", "author1", 1920));
        initialBookList.add(new Book("book1", "author1", 1920));
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
