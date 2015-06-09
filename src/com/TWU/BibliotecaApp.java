package com.TWU;

import java.util.ArrayList;

public class BibliotecaApp {
    MenuView menuView;
    ConsoleOutput consoleOutput;
    ArrayList<Book> initialBookList;

    public BibliotecaApp() {
        initialBookList = new ArrayList<>();
        initialBookList.add(new Book("Lets C", "Yashwant", 1990));
        initialBookList.add(new Book("Head First Java", "Kathy", 1993));
        initialBookList.add(new Book("Learn Java", "John", 2000));
        menuView = new MenuView();
        consoleOutput = new ConsoleOutput();
    }

    public void start() {
        consoleOutput.displayWelcomeMessage();
        MenuView menuView = new MenuView();
        menuView.displayListOfMenu((new Menu()).toString());
        menuView.takeUserInputForMainMenu();
        consoleOutput.displayListOfBooks(new Books(initialBookList));
    }

    public static void main(String args[]){
        BibliotecaApp app = new BibliotecaApp();
        app.start();
    }
}
