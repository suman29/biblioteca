package com.twu;

import com.twu.movies.Movie;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> allBooks;
    private ArrayList<Movie> allMovies;

    public Library(ArrayList<Book> allBooks, ArrayList<Movie> allMovies) {
        this.allBooks = allBooks;
        this.allMovies = allMovies;
    }

    public void checkOutBook(Book book) {
        book.checkOut(allBooks);
    }

    public void returnBook(Book book) {
        book.returnBook(allBooks);
    }

    public ArrayList<Book> getAvailableBooks(ArrayList<Book> availableBooks) {
        availableBooks.clear();

        for (Book book : allBooks)
            book.addItselfToAvailableListOfBooksIfApplicable(availableBooks);

        return availableBooks;
    }

    public ArrayList<Movie> getMovies() {
        return allMovies;
    }

    public Book searcher(String name) {
        for (Book book : allBooks) {
            if ((book.name).equalsIgnoreCase(name))
                return book;
        }
        return allBooks.get(0);
    }
}

