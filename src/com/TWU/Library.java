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

    public void checkOutMovie(Movie movie) {
        movie.checkOut(allMovies);
    }

    public void returnBook(Book book) {
        book.returnBook(allBooks);
    }

    public void returnMovie(Movie movie) {
        movie.returnMovie(allMovies);
    }

    public ArrayList<Book> getAvailableBooks(ArrayList<Book> availableBooks) {
        availableBooks.clear();

        for (Book book : allBooks)
            book.addItselfToAvailableListOfBookIfApplicable(availableBooks);

        return availableBooks;
    }

    public ArrayList<Movie> getAvailableMovies(ArrayList<Movie> availableMovies) {
        availableMovies.clear();

        for (Movie movie : allMovies)
            movie.addItselfToAvailableListOfMovieIfApplicable(availableMovies);
        return availableMovies;
    }

    public Book bookSearcher(String name) {
        return searcher.searchBook(allBooks, name);
    }

    public Movie movieSearcher(String name) {
        return searcher.searchMovie(allMovies, name);
    }
}

