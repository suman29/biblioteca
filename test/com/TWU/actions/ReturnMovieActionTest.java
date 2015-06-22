package com.twu.actions;

import com.twu.Library;
import com.twu.movies.Movie;
import com.twu.views.ReturnMovieView;
import com.twu.users.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReturnMovieActionTest {
    @Mock
    Library library;

    @Mock
    ReturnMovieView returnMovieView;

    @Mock
    Movie movie;

    @Mock
    Customer customer;

    @Test
    public void shouldBeAbleToReturnMovie() {
        when(returnMovieView.takeUserInputForReturningMovie()).thenReturn("hello");
        when(library.movieSearcher("hello"))
                .thenReturn(movie);

        ReturnMovieAction returnMovieAction = new ReturnMovieAction(library, returnMovieView);
        returnMovieAction.perform(customer);

        verify(library).returnMovie(movie);
    }

}