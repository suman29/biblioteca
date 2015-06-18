package com.twu.actions;

import com.twu.Library;
import com.twu.menu.Option;
import com.twu.movies.Movie;
import com.twu.movies.ReturnMovieView;
import com.twu.users.User;

public class ReturnMovieAction implements Option {
    private Library library;
    private ReturnMovieView returnMovieView;

    public ReturnMovieAction(Library library, ReturnMovieView returnMovieView) {
        this.library = library;
        this.returnMovieView = returnMovieView;
    }

    @Override
    public void perform(User customer) {
        String movieTitle = returnMovieView.takeUserInputForReturningMovie();
        Movie movie = library.movieSearcher(movieTitle);
        library.returnMovie(movie);
        returnMovieView.displayMessage(movie.getAppropriateMessageOnReturnMovieAction());
    }

    @Override
    public void perform() {

    }
}
