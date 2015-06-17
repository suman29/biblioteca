package com.twu;

import com.twu.books.AvailableBook;
import com.twu.books.Book;
import com.twu.books.NullBook;
import com.twu.movies.AvailableMovie;
import com.twu.movies.Movie;
import com.twu.movies.NullMovie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class SearcherTest {

    @Mock
    NullBook nullBook;

    @Mock
    NullMovie nullMovie;

    @Test
    public void shouldBeAbleToGiveTheDesiredBook() {
        AvailableBook availableBook = new AvailableBook("Good", "helpMe", 2015, 2);
        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(new AvailableBook("Hello", "helpMe", 2015, 2));
        bookList.add(availableBook);
        Searcher searcher = new Searcher(nullMovie, nullBook);

        String name = "Good";
        Book actualBook = searcher.searchBook(bookList, name);
        AvailableBook expectedBook = availableBook;

        assertEquals(expectedBook, actualBook);
    }

    @Test
    public void shouldBeAbleToGiveTheDesiredMovie() {
        Movie movie = new AvailableMovie("Movie1", 2001, "abc", 1);
        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(new AvailableMovie("Movie2", 2001, "abc", 1));
        movieList.add(movie);
        Searcher searcher = new Searcher(nullMovie, nullBook);

        String name = "Movie1";
        AvailableMovie expectedMovie = (AvailableMovie) movie;
        Movie actualMovie = searcher.searchMovie(movieList, name);

        assertEquals(expectedMovie, actualMovie);
    }

}