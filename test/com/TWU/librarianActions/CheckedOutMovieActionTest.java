package com.twu.librarianActions;

import com.twu.Library;
import com.twu.movies.CheckedOutMovies;
import com.twu.movies.Movie;
import com.twu.users.Customer;
import com.twu.users.Librarian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CheckedOutMovieActionTest {
    @Mock
    Library library;

    @Mock
    LibrarianActionView librarianActionView;

    @Mock
    Customer customer;

    @Test
    public void shouldGiveTheListOfCheckedOutBooksWithCustomerDetails() {
        CheckedOutMovieAction checkedOutMovieAction = new CheckedOutMovieAction(library, librarianActionView);
        Movie movie = new CheckedOutMovies("good", 3, "ede", 2, customer);
        when(librarianActionView.takeUserInputToGetDetailsOfItem())
                .thenReturn("good");
        when(library.checkedMovieSearcher("good")).thenReturn(movie);
        checkedOutMovieAction.perform(new Librarian("", ""));

        verify(library).checkedMovieSearcher("good");
    }
}