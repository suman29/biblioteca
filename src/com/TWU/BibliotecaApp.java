package com.twu;

// Do all The set up needed for the App and starts the App.

import com.twu.movies.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class BibliotecaApp {

    public static void main(String args[]) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Book> availableListOfBooks = availableListOfBooks();
        ArrayList<Book> checkedOutListOfBooks = checkedOutListOfBooks();
        ArrayList<Book> allBooks = new ArrayList<>();
        NullBook nullBook = new NullBook("", "", 0, 0);
        allBooks.add(nullBook);
        availableListOfBooks.addAll(checkedOutListOfBooks);
        allBooks.addAll(availableListOfBooks);
        Books availableBooks = new Books(availableListOfBooks);
        Books checkedOutBooks = new Books(checkedOutListOfBooks);
        BooksView availableBooksView = new BooksView(availableBooks);
        BooksView checkedOutBooksView = new BooksView(checkedOutBooks);

        HashMap<Integer, String> menuList = new HashMap<>();
        HashMap<Integer, Option> mappedOptions = new HashMap<>();
        ArrayList<Movie> allMovies = new ArrayList<>();
        NullMovie nullMovie = new NullMovie("", 0, "", 0);
        allMovies.add(nullMovie);
        allMovies.addAll(initialiseMovies());


        Library library = new Library(allBooks, allMovies, new Searcher());
        creatingMenu(menuList);
        initialisingMenuList(bufferedReader, availableBooksView, checkedOutBooksView, mappedOptions, library);
        Menu menu = new Menu(menuList, mappedOptions);
        MenuView menuView = new MenuView(bufferedReader);
        ConsoleOutput consoleOutput = new ConsoleOutput();

        EntryPoint entryPoint = new EntryPoint(menuView, menu, consoleOutput);
        entryPoint.start();

    }

    private static ArrayList<Movie> initialiseMovies() {
        ArrayList<Movie> allMovies = new ArrayList<>();
        allMovies.add(new AvailableMovie("Batman Begins", 2005, "Christopher Nolan", 9));
        allMovies.add(new AvailableMovie("The Dark Knight", 2008, "Christopher Nolan", 9));
        allMovies.add(new CheckedOutMovies("movie1", 2008, "Christopher Nolan", 9));
        allMovies.add(new CheckedOutMovies("movie2", 2008, "Christopher Nolan", 9));
        return allMovies;
    }

    private static ArrayList<Book> availableListOfBooks() {
        ArrayList<Book> availableBookList;
        availableBookList = new ArrayList<>();
        availableBookList.add(new AvailableBook("Lets C", "Yashwant", 1990, 1));
        availableBookList.add(new AvailableBook("Head First Java", "Kathy", 1993, 2));
        availableBookList.add(new AvailableBook("Learn Java", "John", 2000, 3));
        return availableBookList;
    }

    private static ArrayList<Book> checkedOutListOfBooks() {
        ArrayList<Book> checkedOutBookList;
        checkedOutBookList = new ArrayList<>();
        checkedOutBookList.add(new CheckedOutBook("Book1", "suman", 1990, 3));
        checkedOutBookList.add(new CheckedOutBook("Book2", "Ashray", 1993, 4));
        checkedOutBookList.add(new CheckedOutBook("Book3", "Sourav", 2000, 5));
        return checkedOutBookList;
    }

    private static void initialisingMenuList(BufferedReader bufferedReader, BooksView availableBooksView,
                                             BooksView checkedOutBooksView, HashMap<Integer, Option> mappedOptions, Library library) {
        ArrayList<Book> availableBooks = new ArrayList<>();
        ArrayList<Movie> movies = new ArrayList<>();
        mappedOptions.put(1, new ListBooksAction(availableBooks, library));
        mappedOptions.put(2, new CheckOutAction((new CheckOutView(bufferedReader, availableBooksView)), library));
        mappedOptions.put(3, new ReturnBookAction(library, new ReturnBookView(bufferedReader, checkedOutBooksView)));
        mappedOptions.put(4, new ListMoviesAction(library, movies));
        mappedOptions.put(5, new CheckOutMovieAction((library), new CheckOutMovieView(bufferedReader)));
        mappedOptions.put(6, new ReturnMovieAction(library, new ReturnMovieView(bufferedReader)));
        mappedOptions.put(7, new QuitAction());
    }

    private static void creatingMenu(HashMap<Integer, String> menuList) {
        menuList.put(1, Messages.LIST_BOOKS);
        menuList.put(2, Messages.CHECKOUT_BOOK);
        menuList.put(3, Messages.RETURN_BOOK);
        menuList.put(4, Messages.LIST_MOVIES);
        menuList.put(5, Messages.CHECKOUT_MOVIE);
        menuList.put(6, Messages.RETURN_MOVIE);
        menuList.put(7, Messages.QUIT);
    }
}
