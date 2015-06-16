package com.twu;

import com.twu.movies.Movie;

import java.util.ArrayList;

public class Searcher {
    ArrayList<Book> allBooks;
    ArrayList<Movie> allMovies;

    public Searcher() {
        this.allBooks = null;
        this.allMovies = null;
    }

    public Book searchBook(ArrayList<Book> allBooks, String bookName) {
        for (Book book : allBooks) {
            if ((book.name).equalsIgnoreCase(bookName))
                return book;
        }
        return allBooks.get(0);
    }

    public Movie searchMovie(ArrayList<Movie> allMovies, String name) {
        for (Movie movie : allMovies) {
            if ((movie.name).equalsIgnoreCase(name))
                return movie;
        }
        return allMovies.get(0);
    }
}
