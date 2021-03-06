package com.twu;

// It contains all the messages, which are used in the app.

public interface Messages {
    String WELCOME_MESSAGE = "Welcome";
    String ERROR_MESSAGE = "Select a valid option!";
    String LIST_BOOKS = "List Of Books";
    String CHECKOUT_BOOK = "Checkout Book";
    String RETURN_BOOK = "Return Book";
    String QUIT = "Quit";
    String CHECKOUT_SUCCESSFUL = "Thank you! Enjoy the book";
    String CHECKOUT_UNSUCCESSFUL = "That book is not available.";
    String RETURN_SUCCESSFUL = "Thank you for returning the book.";
    String RETURN_UNSUCCESSFUL = "That is not a valid book to return.";
    String LIST_MOVIES = "List of Movies";
    String CHECKOUT_MOVIE = "Check out Movie";
    String CHECKOUT_MOVIE_SUCCESSFUL = "Thank you! Enjoy the movie.";
    String CHECKOUT_MOVIE_UNSUCCESSFUL = "That movie is not available!";
    String RETURN_MOVIE_UNSUCCESSFUL = "That is not a valid movie to return.";
    String RETURN_MOVIE_SUCCESSFUL = "Thank you for returning the movie.";
    String RETURN_MOVIE = "Return Movie";
    String MOVIE_ALREADY_CHECKED = "This movie is already checked out.";
    String MOVIE_ALREADY_AVAILABLE = "This movie is already available.";
    String BOOK_ALREADY_AVAILABLE = "This book is already available in library.";
    String BOOK_ALREADY_CHECKED = "This book is already checked out";
    String LOGIN_SUCCESSFUL = "Logged in successfully.";
    String LOGIN_UNSUCCESSFUL = "Login unsuccessful, not a valid user!";
    String ENTER_LIBRARY_NUMBER = "Enter your Library number:";
    String ENTER_PASSWORD = "Enter your password:";
    String LOGOUT = "Logout";
    String MY_DETAILS = "Account details";
    String LIST_CHECKED_BOOKS = "List checked out book";
    String LIST_CHECKED_MOVIES = "List checked out movie";
    String LOGIN_CUSTOMER = "Login as Customer";
    String LOGIN_LIBRARIAN = "Login as Librarian";
    String NOT_A_VALID_LIBRARIAN = "Not a valid user!";
    String ENTER_MOVIE_NAME = "Enter the movie name:";
    String ENTER_BOOK_NAME = "Enter the book name:";
    String BOOK_NOT_FOUND_IN_LIBRARY = "Book not found!";
    String MOVIE_NOT_FOUND = "Movie not found!";
}
