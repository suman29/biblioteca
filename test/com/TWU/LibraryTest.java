package com.twu;

import com.twu.books.AvailableBook;
import com.twu.books.Book;
import com.twu.books.CheckedOutBook;
import com.twu.movies.AvailableMovie;
import com.twu.movies.CheckedOutMovies;
import com.twu.movies.Movie;
import com.twu.users.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class LibraryTest {

    ArrayList<Movie> allMovies = new ArrayList<>();
    ArrayList<Book> books = new ArrayList<>();
    @Mock
    AvailableBook availableBook;

    @Mock
    CheckedOutBook checkedOutBook;

    @Mock
    AvailableMovie availableMovie;

    @Test
    public void shouldCheckOutABookWhenUserSelectsABook() {
        ArrayList<Book> booksAvailable = new ArrayList<>();
        AvailableBook book1 = new AvailableBook("abc1", "xyz", 1908, 1);
        booksAvailable.add(book1);
        booksAvailable.add(new AvailableBook("abc2", "xyz", 1908, 2));
        booksAvailable.add(new AvailableBook("abc3", "xyz", 1908, 3));
        Library library = new Library(booksAvailable, allMovies, new Searcher(), new Customer("",""));

        library.checkOutBook(availableBook);

        verify(availableBook).checkOut(booksAvailable, new Customer("",""));
    }

    @Test
    public void shouldCheckOutAMovieWhenUserSelectsAMovie() {
        ArrayList<Movie> moviesAvailable = new ArrayList<>();
        AvailableMovie availableMovie1 = new AvailableMovie("movie1", 2014, "abc", 5);
        moviesAvailable.add(availableMovie1);
        moviesAvailable.add(new AvailableMovie("movie2", 2014, "abc", 5));
        moviesAvailable.add(new AvailableMovie("movie3", 2014, "abc", 5));
        Library library = new Library(books, moviesAvailable, new Searcher(), new Customer("",""));

        library.checkOutMovie(availableMovie);

        verify(availableMovie).checkOut(moviesAvailable);
    }

    @Test
    public void shouldBeAbleToAddReturnedBookWhenUserSelectsABook() {
        ArrayList<Book> booksCheckedOut = new ArrayList<>();
        ArrayList<Book> booksAvailable = new ArrayList<>();
        CheckedOutBook book1 = new CheckedOutBook("abc2", "xyz", 1908, 2, new Customer("",""));
        booksCheckedOut.add(new CheckedOutBook("abc1", "xyz", 1908, 1, new Customer("","")));
        booksCheckedOut.add(book1);
        booksCheckedOut.add(new CheckedOutBook("abc3", "xyz", 1908, 3, new Customer("","")));
        Library library = new Library(booksAvailable, allMovies, new Searcher(), new Customer("",""));

        library.returnBook(book1);

        int actualOutput = booksAvailable.size();
        int expectedOutput = 1;

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void shouldBeABleToDisplayOnlyTheAvailableBooks() {
        ArrayList<Book> allBooks = new ArrayList<>();
        allBooks.add(new AvailableBook("abc2", "xyz", 1908, 2));
        allBooks.add(new AvailableBook("abc3", "xyz", 1908, 3));
        allBooks.add(new CheckedOutBook("abc2", "xyz", 1908, 2, new Customer("","")));
        allBooks.add(new CheckedOutBook("abc1", "xyz", 1908, 1, new Customer("","")));
        Library library = new Library(allBooks, allMovies, new Searcher(), new Customer("",""));
        ArrayList<Book> booksAvailable = new ArrayList<>();
        booksAvailable.add(new AvailableBook("abc2", "xyz", 1908, 2));
        booksAvailable.add(new AvailableBook("abc3", "xyz", 1908, 3));

        ArrayList<Book> abc = new ArrayList<>();

        ArrayList<Book> expectedOutput = booksAvailable;
        ArrayList<Book> actualOutput = library.getAvailableBooks(abc);

        assertEquals(expectedOutput, actualOutput);

    }

    @Test
    public void shouldBeAbleToGiveTheDesiredBook() {
        AvailableBook availableBook = new AvailableBook("God", "helpMe", 2015, 2);
        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(new AvailableBook("good", "helpMe", 2015, 2));
        bookList.add(availableBook);
        Library library = new Library(bookList, allMovies, new Searcher(), new Customer("",""));

        String name = "God";
        AvailableBook expectedBook = availableBook;
        Book actualBook = library.bookSearcher(name);

        assertEquals(expectedBook, actualBook);
    }

    @Test
    public void shouldBeAbleToGiveTheDesiredMovie() {
        Movie movie = new AvailableMovie("Movie1", 2001, "abc", 1);
        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(new AvailableMovie("Movie2", 2001, "abc", 1));
        movieList.add(movie);
        Library library = new Library(books, movieList, new Searcher(), new Customer("",""));

        String name = "Movie1";
        AvailableMovie expectedMovie = (AvailableMovie) movie;
        Movie actualMovie = library.movieSearcher(name);

        assertEquals(expectedMovie, actualMovie);
    }

    @Test
    public void shouldBeAbleToAddReturnedMoviesWhenUserReturnsAMovie() {
        ArrayList<Movie> moviesCheckedout = new ArrayList<>();
        ArrayList<Movie> moviesAvailable = new ArrayList<>();
        CheckedOutMovies movie1 = new CheckedOutMovies("Movie2", 2001, "abc", 1);
        moviesCheckedout.add(new CheckedOutMovies("Movie3", 2001, "abc", 1));
        moviesCheckedout.add(movie1);
        moviesCheckedout.add(new CheckedOutMovies("Movie4", 2001, "abc", 1));
        Library library = new Library(books, moviesAvailable, new Searcher(), new Customer("",""));

        library.returnMovie(movie1);

        int actualOutput = moviesAvailable.size();
        int expectedOutput = 1;

        assertEquals(expectedOutput, actualOutput);
    }
}