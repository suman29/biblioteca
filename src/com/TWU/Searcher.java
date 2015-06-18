package com.twu;

import com.twu.books.Book;
import com.twu.books.NullBook;
import com.twu.movies.Movie;
import com.twu.movies.NullMovie;

import java.util.ArrayList;
import java.util.List;

// It is used whenever we want to search a book or movie in the library.

public class Searcher {

    private NullMovie nullMovie;
    private NullBook nullBook;

    public Searcher(NullMovie nullMovie, NullBook nullBook) {

        this.nullMovie = nullMovie;
        this.nullBook = nullBook;
    }

    public Book searchBook(ArrayList<Book> allBooks, String bookName) {
        List<Book> matchedBooks = new ArrayList<>();
        for (Book book : allBooks) {
            book.addItselfToListIfTitleMatches(matchedBooks, bookName);
        }
        if (matchedBooks.size() > 0)
            return matchedBooks.get(0);
        else
            return nullBook;
    }

    public Movie searchMovie(ArrayList<Movie> allMovies, String name) {
        List<Movie> matchedMovie = new ArrayList<>();
        for (Movie movie : allMovies) {
            movie.addItselfToListIfTitleMatches(matchedMovie, name);
        }
        if (matchedMovie.size() > 0)
            return matchedMovie.get(0);
        else
            return nullMovie;
    }
}
