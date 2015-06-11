package com.twu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class BibliotecaApp {

    public static ArrayList<Book> initializeListOfBooks() {
        ArrayList<Book> availableBookList;
        availableBookList = new ArrayList<>();
        availableBookList.add(new Book("Lets C", "Yashwant", 1990));
        availableBookList.add(new Book("Head First Java", "Kathy", 1993));
        availableBookList.add(new Book("Learn Java", "John", 2000));
        return availableBookList;
    }

    public static void main(String args[]) {
        ArrayList<Book> checkedOutBooks;
        checkedOutBooks = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Book> listOfBooks = initializeListOfBooks();
        Books books = new Books(listOfBooks);
        BooksView booksView = new BooksView(books);
        HashMap<Integer, String> menuList = new HashMap<>();
        HashMap<Integer, Option> mappedOptions = new HashMap<>();
        menuList.put(1, "List Of Books");
        menuList.put(2, "Checkout Books");
        menuList.put(3, "Quit");
        mappedOptions.put(1, new ListBooks(booksView));
        mappedOptions.put(2, new CheckOut((new CheckOutView(bufferedReader, booksView)), new Library(checkedOutBooks, listOfBooks)));
        mappedOptions.put(3, new QuitOption());


        MenuView menuView = new MenuView(bufferedReader);
        ConsoleOutput consoleOutput = new ConsoleOutput();
        Menu menu = new Menu(booksView, menuList, mappedOptions);
        BibliotecaSetUp bibliotecaSetUp = new BibliotecaSetUp(menuView, menu, 1, consoleOutput);
        bibliotecaSetUp.start();
    }
}
