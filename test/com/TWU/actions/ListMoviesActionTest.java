package com.twu.actions;

import com.twu.Library;
import com.twu.actions.ListMoviesAction;
import com.twu.movies.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ListMoviesActionTest {

    @Mock
    Library library;

    @Test
    public void shouldDisplayTheMovies() {
        ArrayList<Movie> movies = new ArrayList<>();
        ListMoviesAction listMoviesAction = new ListMoviesAction(library, movies);
        listMoviesAction.perform();

        verify(library).getAvailableMovies(movies);
    }

}