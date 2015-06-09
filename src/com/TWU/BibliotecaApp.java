package com.TWU;

import java.util.ArrayList;

public class BibliotecaApp {
    MenuView menuView;
    BooksView booksView;
    Books books;
    Menu menu;
    ConsoleOutput consoleOutput;
    ArrayList<Book> initialBookList;


    public BibliotecaApp() {
        initialBookList = new ArrayList<>();
        initialBookList.add(new Book("Lets C", "Yashwant", 1990));
        initialBookList.add(new Book("Head First Java", "Kathy", 1993));
        initialBookList.add(new Book("Learn Java", "John", 2000));
        books = new Books(initialBookList);
        booksView = new BooksView(books);
        consoleOutput = new ConsoleOutput();
        menuView = new MenuView();
        menu = new Menu(booksView);
    }

    public void start() {
        consoleOutput.displayWelcomeMessage();
        menuView.displayListOfMenu(menu);
        int input = menuView.takeUserInputForMainMenu();
        if(menu.isValidInput(input))
            menu.performAction(input);
        else
            menuView.errorMessage();
    }

    public static void main(String args[]){
        BibliotecaApp app = new BibliotecaApp();
        app.start();
    }
}
