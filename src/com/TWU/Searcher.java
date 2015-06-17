package com.twu;

import com.twu.books.Book;
import com.twu.movies.Movie;

import java.util.ArrayList;
import java.util.List;

public class Searcher {
    ArrayList<Book> allBooks;
    ArrayList<Movie> allMovies;

    public Searcher() {
        this.allBooks = null;
        this.allMovies = null;
    }

    public Book searchBook(ArrayList<Book> allBooks, String bookName) {
        List<Book> matchedBooks = new ArrayList<>();
        for (Book book : allBooks) {
            book.addItselfToListIfTitleMatches(matchedBooks, bookName);
        }
        return matchedBooks.get(0);
    }

    public Movie searchMovie(ArrayList<Movie> allMovies, String name) {
        for (Movie movie : allMovies) {
            if ((movie.name).equalsIgnoreCase(name))
                return movie;
        }
        return allMovies.get(0);
    }
}
