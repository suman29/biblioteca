package com.twu;

import com.twu.books.AvailableBook;
import com.twu.books.Book;
import com.twu.books.CheckedOutBook;
import com.twu.books.NullBook;
import com.twu.movies.AvailableMovie;
import com.twu.movies.CheckedOutMovie;
import com.twu.movies.Movie;
import com.twu.movies.NullMovie;
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
    @Mock
    Customer customer;
    @Mock
    NullBook nullBook;
    @Mock
    NullMovie nullMovie;

    @Test
    public void shouldCheckOutABookWhenUserSelectsABook() {
        ArrayList<Book> booksAvailable = new ArrayList<>();
        AvailableBook book1 = new AvailableBook("abc1", "xyz", 1908, 1);
        booksAvailable.add(book1);
        booksAvailable.add(new AvailableBook("abc2", "xyz", 1908, 2));
        booksAvailable.add(new AvailableBook("abc3", "xyz", 1908, 3));
        Library library = new Library(booksAvailable, allMovies, new Searcher(nullMovie, nullBook));

        library.checkOutBook(availableBook, customer);

        verify(availableBook).checkOut(booksAvailable, customer);
    }

    @Test
    public void shouldCheckOutAMovieWhenUserSelectsAMovie() {
        ArrayList<Movie> moviesAvailable = new ArrayList<>();
        AvailableMovie availableMovie1 = new AvailableMovie("movie1", 2014, "abc", 5);
        moviesAvailable.add(availableMovie1);
        moviesAvailable.add(new AvailableMovie("movie2", 2014, "abc", 5));
        moviesAvailable.add(new AvailableMovie("movie3", 2014, "abc", 5));
        Library library = new Library(books, moviesAvailable, new Searcher(nullMovie, nullBook));

        library.checkOutMovie(availableMovie, customer);

        verify(availableMovie).checkOut(moviesAvailable, customer);
    }

    @Test
    public void shouldBeAbleToAddReturnedBookWhenUserSelectsABook() {
        ArrayList<Book> booksCheckedOut = new ArrayList<>();
        ArrayList<Book> booksAvailable = new ArrayList<>();
        CheckedOutBook book1 = new CheckedOutBook("abc2", "xyz", 1908, 2, customer);
        booksCheckedOut.add(new CheckedOutBook("abc1", "xyz", 1908, 1, customer));
        booksCheckedOut.add(book1);
        booksCheckedOut.add(new CheckedOutBook("abc3", "xyz", 1908, 3, customer));
        Library library = new Library(booksAvailable, allMovies, new Searcher(nullMovie, nullBook));

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
        allBooks.add(new CheckedOutBook("abc2", "xyz", 1908, 2, customer));
        allBooks.add(new CheckedOutBook("abc1", "xyz", 1908, 1, customer));
        Library library = new Library(allBooks, allMovies, new Searcher(nullMovie, nullBook));
        ArrayList<Book> booksAvailable = new ArrayList<>();
        booksAvailable.add(new AvailableBook("abc2", "xyz", 1908, 2));
        booksAvailable.add(new AvailableBook("abc3", "xyz", 1908, 3));
        ArrayList<Book> list = new ArrayList<>();

        ArrayList<Book> expectedOutput = booksAvailable;
        ArrayList<Book> actualOutput = library.getAvailableBooks(list);

        assertEquals(expectedOutput, actualOutput);

    }

    @Test
    public void shouldBeABleToDisplayOnlyCheckedOutBooks() {
        ArrayList<Book> allBooks = new ArrayList<>();
        allBooks.add(new AvailableBook("abc2", "xyz", 1908, 2));
        allBooks.add(new AvailableBook("abc3", "xyz", 1908, 3));
        allBooks.add(new CheckedOutBook("abc2", "xyz", 1908, 2, customer));
        allBooks.add(new CheckedOutBook("abc1", "xyz", 1908, 1, customer));
        Library library = new Library(allBooks, allMovies, new Searcher(nullMovie, nullBook));
        ArrayList<Book> booksChecked = new ArrayList<>();
        booksChecked.add(new CheckedOutBook("abc2", "xyz", 1908, 2, customer));
        booksChecked.add(new CheckedOutBook("abc1", "xyz", 1908, 1, customer));
        ArrayList<Book> list = new ArrayList<>();

        ArrayList<Book> expectedOutput = booksChecked;
        ArrayList<Book> actualOutput = library.getCheckedOutBooks(list);

        assertEquals(expectedOutput, actualOutput);

    }

    @Test
    public void shouldBeAbleToGiveTheDesiredBook() {
        AvailableBook availableBook = new AvailableBook("God", "helpMe", 2015, 2);
        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(new AvailableBook("good", "helpMe", 2015, 2));
        bookList.add(availableBook);
        Library library = new Library(bookList, allMovies, new Searcher(nullMovie, nullBook));
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
        Library library = new Library(books, movieList, new Searcher(nullMovie, nullBook));
        String name = "Movie1";

        AvailableMovie expectedMovie = (AvailableMovie) movie;
        Movie actualMovie = library.movieSearcher(name);

        assertEquals(expectedMovie, actualMovie);
    }

    @Test
    public void shouldBeAbleToAddReturnedMoviesWhenUserReturnsAMovie() {
        ArrayList<Movie> moviesCheckedout = new ArrayList<>();
        ArrayList<Movie> moviesAvailable = new ArrayList<>();
        CheckedOutMovie movie1 = new CheckedOutMovie("Movie2", 2001, "abc", 1, customer);
        moviesCheckedout.add(new CheckedOutMovie("Movie3", 2001, "abc", 1, customer));
        moviesCheckedout.add(movie1);
        moviesCheckedout.add(new CheckedOutMovie("Movie4", 2001, "abc", 1, customer));
        Library library = new Library(books, moviesAvailable, new Searcher(nullMovie, nullBook));
        library.returnMovie(movie1);

        int actualOutput = moviesAvailable.size();
        int expectedOutput = 1;

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void shouldBeAbleToGiveCheckedOutMovies() {
        ArrayList<Movie> moviesCheckedout = new ArrayList<>();
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new CheckedOutMovie("Movie2", 2001, "abc", 1, customer));
        movies.add(new CheckedOutMovie("Movie3", 2001, "abc", 1, customer));
        movies.add(new CheckedOutMovie("Movie4", 2001, "abc", 1, customer));
        Library library = new Library(books, movies, new Searcher(nullMovie, nullBook));
        library.getCheckedOutMovies(moviesCheckedout);

        int actualOutput = moviesCheckedout.size();
        int expectedOutput = 3;

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void shouldGiveAvailableMovies() {
        ArrayList<Movie> movies = new ArrayList<>();
        ArrayList<Movie> moviesAvailable = new ArrayList<>();
        movies.add(new CheckedOutMovie("Movie2", 2001, "abc", 1, customer));
        movies.add(new CheckedOutMovie("Movie3", 2001, "abc", 1, customer));
        movies.add(new AvailableMovie("movie2", 2014, "abc", 5));
        movies.add(new AvailableMovie("movie3", 2014, "abc", 5));
        Library library = new Library(books, movies, new Searcher(nullMovie, nullBook));
        library.getAvailableMovies(moviesAvailable);

        int actualOutput = moviesAvailable.size();
        int expectedOutput = 2;

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void shouldGiveACheckedBookOnSearching(){
        ArrayList<Book> allBooks = new ArrayList<>();
        Book book1=new CheckedOutBook("abc2", "xyz", 1908, 2, customer);
        allBooks.add(new AvailableBook("abc2", "xyz", 1908, 2));
        allBooks.add(new AvailableBook("abc3", "xyz", 1908, 3));
        allBooks.add(book1);
        allBooks.add(new CheckedOutBook("abc1", "xyz", 1908, 1, customer));
        Library library = new Library(allBooks, allMovies, new Searcher(nullMovie, nullBook));

        Book actualBook = library.checkedBookSearcher("abc2");

        assertEquals(actualBook, book1);
    }
}