package com.TWU;

import java.util.ArrayList;

public class BibliotecaApp {
    MenuView menuView;
    BooksView booksView;
    Menu menu;
    int input;
    ConsoleOutput consoleOutput;


    public BibliotecaApp(Books books, ConsoleOutput consoleOutput) {
        booksView = new BooksView(books);
        this.consoleOutput = consoleOutput;
        menuView = new MenuView();
        menu = new Menu(booksView);
        input = 1;
    }

    public void start() {
        consoleOutput.displayWelcomeMessage();
        menuIteration();
    }

    private void menuIteration() {
        while (input > 0) {
            menuView.displayListOfMenu(menu);
            input = menuView.takeUserInputForMainMenu();
            if (menu.isValidInput(input))
                menu.performAction(input);
            else
                menuView.errorMessage();
        }
    }

    public static void main(String args[]) {

        ArrayList<Book> initialBookList;
        initialBookList = new ArrayList<>();
        initialBookList.add(new Book("Lets C", "Yashwant", 1990));
        initialBookList.add(new Book("Head First Java", "Kathy", 1993));
        initialBookList.add(new Book("Learn Java", "John", 2000));

        Books books = new Books(initialBookList);
        ConsoleOutput consoleOutput = new ConsoleOutput();

        BibliotecaApp app = new BibliotecaApp(books, consoleOutput);
        app.start();
    }
}
