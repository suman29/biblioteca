package com.twu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class BibliotecaSetUp {

    public static void main(String args[]) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Book> availableListOfBooks = availableListOfBooks();
        ArrayList<Book> checkedOutListOfBooks = checkedOutListOfBooks();
        Books availableBooks = new Books(availableListOfBooks);
        Books checkedOutBooks = new Books(checkedOutListOfBooks);
        BooksView availableBooksView = new BooksView(availableBooks);
        BooksView checkedOutBooksView = new BooksView(checkedOutBooks);

        HashMap<Integer, String> menuList = new HashMap<>();
        HashMap<Integer, Option> mappedOptions = new HashMap<>();

        Library library = new Library(checkedOutListOfBooks, availableListOfBooks);
        creatingMenu(menuList);
        initialisingMenuList(bufferedReader, availableBooksView, checkedOutBooksView, mappedOptions, library);
        Menu menu = new Menu(menuList, mappedOptions);
        MenuView menuView = new MenuView(bufferedReader);
        ConsoleOutput consoleOutput = new ConsoleOutput();

        BibliotecaApp bibliotecaApp = new BibliotecaApp(menuView, menu, consoleOutput);
        bibliotecaApp.start();

    }

    private static ArrayList<Book> availableListOfBooks() {
        ArrayList<Book> availableBookList;
        availableBookList = new ArrayList<>();
        availableBookList.add(new Book("Lets C", "Yashwant", 1990));
        availableBookList.add(new Book("Head First Java", "Kathy", 1993));
        availableBookList.add(new Book("Learn Java", "John", 2000));
        return availableBookList;
    }

    private static ArrayList<Book> checkedOutListOfBooks() {
        ArrayList<Book> checkedOutBookList;
        checkedOutBookList = new ArrayList<>();
        checkedOutBookList.add(new Book("Book1", "suman", 1990));
        checkedOutBookList.add(new Book("Book2", "Ashray", 1993));
        checkedOutBookList.add(new Book("Book3", "Sourav", 2000));
        return checkedOutBookList;
    }

    private static void initialisingMenuList(BufferedReader bufferedReader, BooksView availableBooksView,
                                             BooksView checkedOutBooksView, HashMap<Integer, Option> mappedOptions, Library library) {
        mappedOptions.put(1, new ListBooks(availableBooksView));
        mappedOptions.put(2, new CheckOut((new CheckOutView(bufferedReader, availableBooksView)), library));
        mappedOptions.put(3, new ReturnBook(library, new ReturnBookView(bufferedReader, checkedOutBooksView)));
        mappedOptions.put(4, new QuitOption());
    }

    private static void creatingMenu(HashMap<Integer, String> menuList) {
        menuList.put(1, "List Of Books");
        menuList.put(2, "Checkout Book");
        menuList.put(3, "Return Book");
        menuList.put(4, "Quit");
    }
}
