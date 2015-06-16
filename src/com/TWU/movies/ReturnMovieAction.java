package com.twu.movies;

import com.twu.Library;
import com.twu.Option;

public class ReturnMovieAction implements Option {
    private Library library;
    private ReturnMovieView returnMovieView;

    public ReturnMovieAction(Library library, ReturnMovieView returnMovieView) {
        this.library = library;
        this.returnMovieView = returnMovieView;
    }

    @Override
    public void perform() {
        String movieTitle = returnMovieView.takeUserInputForReturningMovie();
        Movie movie = library.movieSearcher(movieTitle);
        library.returnMovie(movie);
        movie.getAppropriateMessageOnReturnMovieAction();
    }
}