package com.twu.menu;

import com.twu.Library;
import com.twu.books.Book;
import com.twu.librarianActions.CheckedOutBooksAction;
import com.twu.librarianActions.CheckedOutMovieAction;
import com.twu.librarianActions.LibrarianActionView;
import com.twu.movies.Movie;
import com.twu.users.Librarian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LibrarianMenuTest {

    @Mock
    Library library;
    @Mock
    Librarian user;
    @Mock
    LibrarianActionView librarianActionView;

    HashMap<Integer, String> menuListLibrarian;
    HashMap<Integer, Option> mappedOptions;

    @Before
    public void setUp() throws Exception {
        menuListLibrarian = new HashMap<>();
        mappedOptions = new HashMap<>();
        menuListLibrarian.put(1, "Checked out books");
        menuListLibrarian.put(2, "Checked out movies");
        ArrayList<Book> checkedbooks = new ArrayList<>();
        ArrayList<Movie> checkedMovies = new ArrayList<>();
        mappedOptions.put(1, new CheckedOutBooksAction(library, librarianActionView));
        mappedOptions.put(2, new CheckedOutMovieAction(library, librarianActionView));

    }

    @Test
    public void checkIfMenuIsRepresentedProperly() {
        LibrarianMenu librarianMenu = new LibrarianMenu(menuListLibrarian, mappedOptions, user);

        String actualOutput = librarianMenu.toString();
        String expectedOutput = "\n1. Checked out books" + System.lineSeparator() + "2. Checked out movies" + System.lineSeparator() + "Enter your choice:\n\n";

        assertEquals(expectedOutput, actualOutput);
    }

}