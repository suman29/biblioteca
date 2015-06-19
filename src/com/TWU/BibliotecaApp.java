package com.twu;

// Do all The set up needed for the App and starts the App.

import com.twu.actions.*;
import com.twu.books.*;
import com.twu.librarianActions.CheckedOutBooksAction;
import com.twu.librarianActions.CheckedOutMovieAction;
import com.twu.librarianActions.LibrarianActionView;
import com.twu.menu.*;
import com.twu.movies.*;
import com.twu.users.Customer;
import com.twu.users.Librarian;
import com.twu.users.NullUser;
import com.twu.users.User;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class BibliotecaApp {

    public static void main(String args[]) {
        ArrayList<Book> allBooks = new ArrayList<>();
        ArrayList<Book> availableListOfBooks = availableListOfBooks();
        ArrayList<Book> checkedOutListOfBooks = checkedOutListOfBooks();
        NullBook nullBook = populateBooks(allBooks, availableListOfBooks, checkedOutListOfBooks);

        ArrayList<Movie> allMovies = new ArrayList<>();
        NullMovie nullMovie = populateMovies(allMovies);

        Library library = new Library(allBooks, allMovies, new Searcher(nullMovie, nullBook));
        Set<User> allUsers = new HashSet<>();
        populatingUsers(allUsers);

        Librarian librarian = new Librarian("", "");
        NullUser nullUser = new NullUser("", "");
        User user = new Customer("", "", "", "", "");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<User> list = new ArrayList<>();
        LoginController loginController = new LoginController(new LoginView(bufferedReader), new Authenticator(allUsers, nullUser, list), nullUser);
        ConsoleOutput consoleOutput = new ConsoleOutput();

        CustomerMenu customerMenu = getCustomerMenu(bufferedReader, availableListOfBooks, checkedOutListOfBooks, library, user, loginController);
        LibrarianMenu librarianMenu = getLibrarianMenu(library, librarian, loginController);
        MenuView menuView = new MenuView(bufferedReader);
        MainMenu mainMenu = getMainMenu(library, loginController, customerMenu, librarianMenu, menuView);

        EntryPoint entryPoint = new EntryPoint(menuView, consoleOutput, mainMenu);
        entryPoint.start();
    }

    private static NullMovie populateMovies(ArrayList<Movie> allMovies) {
        NullMovie nullMovie = new NullMovie("", 0, "", 0, new Customer("", "", "", "", ""));
        allMovies.add(nullMovie);
        allMovies.addAll(initialiseMovies());
        return nullMovie;
    }

    private static NullBook populateBooks(ArrayList<Book> allBooks, ArrayList<Book> availableListOfBooks, ArrayList<Book> checkedOutListOfBooks) {
        NullBook nullBook = new NullBook("", "", 0, 0);
        allBooks.add(nullBook);
        availableListOfBooks.addAll(checkedOutListOfBooks);
        allBooks.addAll(availableListOfBooks);
        return nullBook;
    }

    private static MainMenu getMainMenu(Library library, LoginController loginController, CustomerMenu customerMenu, LibrarianMenu librarianMenu, MenuView menuView) {
        HashMap<Integer, Option> mappedOptionsMain = new HashMap<>();
        HashMap<Integer, String> menuListMain = new HashMap<>();
        populatingMainMenu(library, customerMenu, menuView, loginController, librarianMenu, menuListMain, mappedOptionsMain);
        return new MainMenu(menuListMain, mappedOptionsMain);
    }

    private static LibrarianMenu getLibrarianMenu(Library library, Librarian librarian, LoginController loginController) {
        HashMap<Integer, Option> mappedOptionLibrarian = new HashMap<>();
        HashMap<Integer, String> menuListLibrarian = new HashMap<>();
        populatingForLibrarian(mappedOptionLibrarian, library, menuListLibrarian, loginController);
        return new LibrarianMenu(menuListLibrarian, mappedOptionLibrarian);
    }

    private static CustomerMenu getCustomerMenu(BufferedReader bufferedReader, ArrayList<Book> availableListOfBooks, ArrayList<Book> checkedOutListOfBooks, Library library, User user, LoginController loginController) {
        HashMap<Integer, Option> mappedOptions = new HashMap<>();
        HashMap<Integer, String> menuList = new HashMap<>();
        Books availableBooks = new Books(availableListOfBooks);
        Books checkedOutBooks = new Books(checkedOutListOfBooks);
        BooksView availableBooksView = new BooksView(availableBooks);
        BooksView checkedOutBooksView = new BooksView(checkedOutBooks);
        creatingMenuForCustomer(menuList);
        initialisingMenuListForCustomer(bufferedReader, availableBooksView, checkedOutBooksView, mappedOptions, library, loginController);
        return new CustomerMenu(menuList, mappedOptions);
    }

    private static void populatingUsers(Set<User> allUsers) {
        allUsers.add(new Customer("123-abc1", "1234", "suman", "abc@gmail.com", "7205787250"));
        allUsers.add(new Customer("123-abc2", "1234", "ashray", "abc@gmail.com", "7205787250"));
        allUsers.add(new Customer("123-abc3", "1234", "sourav", "abc@gmail.com", "7205787250"));
        allUsers.add(new Librarian("abc-1234", "abcd"));
        allUsers.add(new Librarian("abc-2345", "abcd"));
        allUsers.add(new Librarian("abc-3456", "abcd"));
    }

    private static void populatingMainMenu(Library library, CustomerMenu customerMenu, MenuView menuView, LoginController loginController, LibrarianMenu librarianMenu, HashMap<Integer, String> menuListMain, HashMap<Integer, Option> mappedOptionsMain) {
        menuListMain.put(1, Messages.LIST_BOOKS);
        menuListMain.put(2, Messages.LIST_MOVIES);
        menuListMain.put(3, Messages.LOGIN_CUSTOMER);
        menuListMain.put(4, Messages.LOGIN_LIBRARIAN);
        menuListMain.put(5, Messages.QUIT);
        NullUser nullUser = new NullUser("", "");
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Movie> movies = new ArrayList<>();
        mappedOptionsMain.put(1, new ListBooksAction(books, library));
        mappedOptionsMain.put(2, new ListMoviesAction(library, movies));
        mappedOptionsMain.put(3, new CustomerLogin(loginController, menuView, customerMenu,nullUser));
        mappedOptionsMain.put(4, new LibrarianLogin(loginController, menuView, librarianMenu, nullUser));
        mappedOptionsMain.put(5, new QuitAction());
    }

    private static void populatingForLibrarian(HashMap<Integer, Option> mappedOptions, Library library, HashMap<Integer, String> menuListLibrarian, LoginController loginController) {
        menuListLibrarian.put(1, Messages.LIST_CHECKED_BOOKS);
        menuListLibrarian.put(2, Messages.LIST_CHECKED_MOVIES);
        menuListLibrarian.put(4, Messages.LOGOUT);
        menuListLibrarian.put(3, Messages.QUIT);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        mappedOptions.put(1, new CheckedOutBooksAction(library, new LibrarianActionView(br)));
        mappedOptions.put(2, new CheckedOutMovieAction(library, new LibrarianActionView(br)));
        mappedOptions.put(4, new Logout(loginController));
        mappedOptions.put(3, new QuitAction());
    }

    private static ArrayList<Movie> initialiseMovies() {
        ArrayList<Movie> allMovies = new ArrayList<>();
        String name = "ashray";
        String email = "123@yh.com";
        String number = "7205787250";
        allMovies.add(new AvailableMovie("Batman Begins", 2005, "Christopher Nolan", 9));
        allMovies.add(new AvailableMovie("The Dark Knight", 2008, "Christopher Nolan", 9));
        allMovies.add(new CheckedOutMovie("movie1", 2008, "Christopher Nolan", 9, new Customer("Ashray", "", name, email, number)));
        allMovies.add(new CheckedOutMovie("movie2", 2008, "Christopher Nolan", 9, new Customer("Suman", "", name, email, number)));
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
        String name = "ashray";
        String email = "123@yh.com";
        String number = "7205787250";
        checkedOutBookList.add(new CheckedOutBook("Book1", "suman", 1990, 3, new Customer("Ashray", "", name, email, number)));
        checkedOutBookList.add(new CheckedOutBook("Book2", "Ashray", 1993, 4, new Customer("Suman", "", name, email, number)));
        checkedOutBookList.add(new CheckedOutBook("Book3", "Sourav", 2000, 5, new Customer("Sourav", "", name, email, number)));
        return checkedOutBookList;
    }

    private static void initialisingMenuListForCustomer(BufferedReader bufferedReader, BooksView availableBooksView,
                                                        BooksView checkedOutBooksView, HashMap<Integer, Option> mappedOptions, Library library, LoginController loginController) {
        ArrayList<Book> availableBooks = new ArrayList<>();
        ArrayList<Movie> movies = new ArrayList<>();
        mappedOptions.put(1, new ListBooksAction(availableBooks, library));
        mappedOptions.put(2, new CheckOutBookAction((new CheckOutView(bufferedReader, availableBooksView)), library));
        mappedOptions.put(3, new ReturnBookAction(library, new ReturnBookView(bufferedReader, checkedOutBooksView)));
        mappedOptions.put(4, new ListMoviesAction(library, movies));
        mappedOptions.put(5, new CheckOutMovieAction((library), new CheckOutMovieView(bufferedReader)));
        mappedOptions.put(6, new ReturnMovieAction(library, new ReturnMovieView(bufferedReader)));
        mappedOptions.put(7, new CustomerDetailsAction());
        mappedOptions.put(8, new QuitAction());
        mappedOptions.put(9, new Logout(loginController));
    }

    private static void creatingMenuForCustomer(HashMap<Integer, String> menuList) {
        menuList.put(1, Messages.LIST_BOOKS);
        menuList.put(2, Messages.CHECKOUT_BOOK);
        menuList.put(3, Messages.RETURN_BOOK);
        menuList.put(4, Messages.LIST_MOVIES);
        menuList.put(5, Messages.CHECKOUT_MOVIE);
        menuList.put(6, Messages.RETURN_MOVIE);
        menuList.put(7, Messages.MY_DETAILS);
        menuList.put(8, Messages.QUIT);
        menuList.put(9, Messages.LOGOUT);
    }
}
