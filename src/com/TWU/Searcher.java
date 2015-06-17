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
        if(matchedBooks.size() > 0)
            return matchedBooks.get(0);
        else
            return allBooks.get(0);
    }

    public Movie searchMovie(ArrayList<Movie> allMovies, String name) {
        List<Movie> matchedMovie = new ArrayList<>();
        for (Movie movie : allMovies) {
           movie.addItselfToListIfTitleMatches(matchedMovie, name);
        }
        if(matchedMovie.size() > 0)
            return matchedMovie.get(0);
        else
            return allMovies.get(0);
    }
}
