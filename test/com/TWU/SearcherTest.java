package com.twu;

import com.twu.movies.AvailableMovie;
import com.twu.movies.Movie;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SearcherTest {

    @Test
    public void shouldBeAbleToGiveTheDesiredBook() {
        AvailableBook availableBook = new AvailableBook("Good", "helpMe", 2015, 2);
        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(new AvailableBook("Hello", "helpMe", 2015, 2));
        bookList.add(availableBook);
        Searcher searcher = new Searcher();

        String name = "Good";
        AvailableBook expectedBook = availableBook;
        Book actualBook = searcher.searchBook(bookList, name);

        assertEquals(expectedBook, actualBook);
    }

    @Test
    public void shouldBeAbleToGiveTheDesiredMovie() {
        Movie movie = new AvailableMovie("Movie1", 2001, "abc", 1);
        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(new AvailableMovie("Movie2", 2001, "abc", 1));
        movieList.add(movie);
        Searcher searcher = new Searcher();

        String name = "Movie1";
        AvailableMovie expectedMovie = (AvailableMovie) movie;
        Movie actualMovie = searcher.searchMovie(movieList, name);

        assertEquals(expectedMovie, actualMovie);
    }

}