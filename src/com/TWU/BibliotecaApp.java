package com.twu;

import java.util.ArrayList;
import java.util.HashMap;

public class BibliotecaApp {

    public static ArrayList<Book> initializeListOfBooks() {
        ArrayList<Book> initialBookList;
        initialBookList = new ArrayList<>();
        initialBookList.add(new Book("Lets C", "Yashwant", 1990));
        initialBookList.add(new Book("Head First Java", "Kathy", 1993));
        initialBookList.add(new Book("Learn Java", "John", 2000));
        return initialBookList;
    }

    public static void main(String args[]) {

        Books books = new Books(initializeListOfBooks());
        BooksView booksView = new BooksView(books);
        HashMap<Integer, String> menuList = new HashMap<>() ;
        HashMap<Integer, Option> mappedOptions = new HashMap<>();
        menuList.put(1, "List Of Books");
        menuList.put(2, "Quit");
        mappedOptions.put(1, new ListBooks(booksView));
        mappedOptions.put(2, new QuitOption());

        BibliotecaSetUp bibliotecaSetUp = new BibliotecaSetUp(new MenuView(), new Menu(booksView,menuList,mappedOptions), 1, new ConsoleOutput());
        bibliotecaSetUp.start();
    }
}
