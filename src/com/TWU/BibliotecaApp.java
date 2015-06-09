package com.TWU;

import java.util.ArrayList;

public class BibliotecaApp {
    MenuView menuView;
    BooksView booksView;
    Books books;
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
    }

    public void start() {
        consoleOutput.displayWelcomeMessage();
        menuView.displayListOfMenu((new Menu()));
        menuView.takeUserInputForMainMenu();
        booksView.displayListOfBooks();
    }

    public static void main(String args[]){
        BibliotecaApp app = new BibliotecaApp();
        app.start();
    }
}
