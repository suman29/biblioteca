package com.twu.actions;

import com.twu.Library;
import com.twu.actions.CheckOutMovieAction;
import com.twu.movies.AvailableMovie;
import com.twu.movies.CheckOutMovieView;
import com.twu.movies.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CheckOutMovieActionTest {
    @Mock
    Library library;

    @Mock
    CheckOutMovieView checkOutMovieView;

    @Test
    public void shouldCheckOutBooks() {
        when(checkOutMovieView.takeUserInputForCheckOutMovie()).thenReturn("movie1");
        ArrayList<Movie> list = new ArrayList<>();
        Movie movie = new AvailableMovie("movie1", 2001, "abc", 1);
        when(library.movieSearcher("movie1"))
                .thenReturn(movie);

        CheckOutMovieAction checkOutMovie = new CheckOutMovieAction(library, checkOutMovieView);
        checkOutMovie.perform();

        verify(library).checkOutMovie(movie);
    }

}