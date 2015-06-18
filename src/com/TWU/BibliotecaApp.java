package com.twu;

// Do all The set up needed for the App and starts the App.

import com.twu.actions.*;
import com.twu.books.*;
import com.twu.librarianActions.CheckedOutBooksAction;
import com.twu.librarianActions.CheckedOutMovieAction;
import com.twu.librarianActions.LibrarianActionView;
import com.twu.menu.CustomerMenu;
import com.twu.menu.LibrarianMenu;
import com.twu.menu.MenuView;
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

        String name = "ashray";
        String email = "123@yh.com";
        String number="7205787250";
        ArrayList<Movie> allMovies = new ArrayList<>();
        NullMovie nullMovie = new NullMovie("", 0, "", 0, new Customer("", "", name, email, number));
        allMovies.add(nullMovie);
        allMovies.addAll(initialiseMovies());

        HashMap<Integer, String> menuList = new HashMap<>();
        HashMap<Integer, Option> mappedOptions = new HashMap<>();

        Library library = new Library(allBooks, allMovies, new Searcher(nullMovie, nullBook));
        creatingMenu(menuList);

        NullUser nullUser = new NullUser("", "");
        Librarian librarian = new Librarian("", "");
        User user = new Customer("", "", name, email, number);
        CustomerMenu customerMenu = new CustomerMenu(menuList, mappedOptions, user);

        MenuView menuView = new MenuView(bufferedReader);
        ConsoleOutput consoleOutput = new ConsoleOutput();
        ArrayList<User> list = new ArrayList<>();

        Set<User> allUsers = new HashSet<>();
        allUsers.add(new Customer("123-4567", "1234", name, email, number));
        allUsers.add(new Librarian("abc-1234", "abcd"));
        LoginController loginController = new LoginController(new LoginView(bufferedReader), new Authenticator(allUsers, nullUser, list), nullUser);
        initialisingMenuList(bufferedReader, availableBooksView, checkedOutBooksView, mappedOptions, library, loginController);

        HashMap<Integer, Option> mappedOptionLibrarian = new HashMap<>();
        HashMap<Integer, String> menuListLibrarian = new HashMap<>();
        populatingForLibrarian(mappedOptionLibrarian, library, menuListLibrarian, loginController);

        LibrarianMenu librarianMenu = new LibrarianMenu(menuListLibrarian, mappedOptionLibrarian, librarian);


        EntryPoint entryPoint = new EntryPoint(menuView, customerMenu, consoleOutput, loginController, librarianMenu);
        entryPoint.start();

    }

    private static void populatingForLibrarian(HashMap<Integer, Option> mappedOptions, Library library, HashMap<Integer, String> menuListLibrarian, LoginController loginController) {
        menuListLibrarian.put(1, Messages.LIST_CHECKED_BOOKS);
        menuListLibrarian.put(2, Messages.LIST_CHECKED_MOVIES);
        menuListLibrarian.put(4, Messages.LOGOUT);
        menuListLibrarian.put(3, Messages.QUIT);
        ArrayList<Book> checkedbooks = new ArrayList<>();
        ArrayList<Movie> checkedMovies = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        mappedOptions.put(1, new CheckedOutBooksAction(library,new LibrarianActionView(br)));
        mappedOptions.put(2, new CheckedOutMovieAction(library, checkedMovies));
        mappedOptions.put(4, new Logout(loginController));
        mappedOptions.put(3, new QuitAction());
    }

    private static ArrayList<Movie> initialiseMovies() {
        ArrayList<Movie> allMovies = new ArrayList<>();
        String name = "ashray";
        String email = "123@yh.com";
        String number="7205787250";
        allMovies.add(new AvailableMovie("Batman Begins", 2005, "Christopher Nolan", 9));
        allMovies.add(new AvailableMovie("The Dark Knight", 2008, "Christopher Nolan", 9));
        allMovies.add(new CheckedOutMovies("movie1", 2008, "Christopher Nolan", 9, new Customer("Ashray", "", name, email, number)));
        allMovies.add(new CheckedOutMovies("movie2", 2008, "Christopher Nolan", 9, new Customer("Suman", "", name, email, number)));
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
        String number="7205787250";
        checkedOutBookList.add(new CheckedOutBook("Book1", "suman", 1990, 3, new Customer("Ashray", "", name, email, number)));
        checkedOutBookList.add(new CheckedOutBook("Book2", "Ashray", 1993, 4, new Customer("Suman", "", name, email, number)));
        checkedOutBookList.add(new CheckedOutBook("Book3", "Sourav", 2000, 5, new Customer("Sourav", "", name, email, number)));
        return checkedOutBookList;
    }

    private static void initialisingMenuList(BufferedReader bufferedReader, BooksView availableBooksView,
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

    private static void creatingMenu(HashMap<Integer, String> menuList) {
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
