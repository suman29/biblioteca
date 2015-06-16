package com.twu.movies;

import com.twu.Library;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ListMoviesActionTest {

    @Mock
    Library library;

    @Test
    public void shouldDisplayTheMovies() {
        ListMoviesAction listMoviesAction = new ListMoviesAction(library);
        listMoviesAction.perform();

        verify(library).getMovies();
    }

}