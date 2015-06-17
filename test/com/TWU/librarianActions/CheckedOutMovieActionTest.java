package com.twu.librarianActions;

import com.twu.Library;
import com.twu.movies.Movie;
import com.twu.users.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CheckedOutMovieActionTest {
    @Mock
    Library library;

    @Mock
    Customer customer;

    @Test
    public void shouldGiveTheListOfCheckedOutBooksWithCustomerDetails() {
        ArrayList<Movie> list = new ArrayList<>();
        CheckedOutMovieAction checkedOutMovieAction = new CheckedOutMovieAction(library, list);
        checkedOutMovieAction.perform(customer);

        verify(library).getCheckedOutMovies(list);
    }
}