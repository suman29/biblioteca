package com.twu;

import com.twu.movies.Movie;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> allBooks;
    private ArrayList<Movie> allMovies;
    private Searcher searcher;

    public Library(ArrayList<Book> allBooks, ArrayList<Movie> allMovies, Searcher searcher) {
        this.allBooks = allBooks;
        this.allMovies = allMovies;
        this.searcher = searcher;
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
       return searcher.searchBook(allBooks,name);
    }
}

