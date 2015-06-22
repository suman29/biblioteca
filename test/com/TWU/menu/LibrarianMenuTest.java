package com.twu.menu;

import com.twu.Library;
import com.twu.Logout;
import com.twu.librarianActions.CheckedOutBooksAction;
import com.twu.librarianActions.CheckedOutMovieAction;
import com.twu.librarianActions.LibrarianActionView;
import com.twu.users.Librarian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

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
    @Mock
    Logout logout;

    HashMap<Integer, String> menuListLibrarian;
    HashMap<Integer, Option> mappedOptions;

    @Before
    public void setUp() throws Exception {
        menuListLibrarian = new HashMap<>();
        mappedOptions = new HashMap<>();
        menuListLibrarian.put(1, "Checked out books");
        menuListLibrarian.put(2, "Checked out movies");
        mappedOptions.put(1, new CheckedOutBooksAction(library, librarianActionView));
        mappedOptions.put(2, new CheckedOutMovieAction(library, librarianActionView));
        mappedOptions.put(3, logout);

    }

    @Test
    public void checkIfMenuIsRepresentedProperly() {
        LibrarianMenu librarianMenu = new LibrarianMenu(menuListLibrarian, mappedOptions);

        String actualOutput = librarianMenu.toString();
        String expectedOutput = "\n1. Checked out books" + System.lineSeparator() + "2. Checked out movies" + System.lineSeparator() + "Enter your choice:\n\n";

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void checkIfCorrectActionIsPerformed() {
        LibrarianMenu librarianMenu = new LibrarianMenu(this.menuListLibrarian, mappedOptions);
        librarianMenu.performAction(3, user);

        Mockito.verify(logout).perform(user);
    }

    @Test
    public void checkIfTheInputIsValid() {
        LibrarianMenu librarianMenu = new LibrarianMenu(menuListLibrarian, mappedOptions);

        boolean actualOutput = librarianMenu.isValidInput(5);
        boolean expectedOutput = false;

        assertEquals(expectedOutput, actualOutput);
    }
}