package com.twu.movies;

import com.twu.Library;
import com.twu.Option;

public class CheckOutMovieAction implements Option {
    private Library library;
    private CheckOutMovieView checkOutMovieView;

    public CheckOutMovieAction(Library library, CheckOutMovieView checkOutMovieView) {
        this.library = library;
        this.checkOutMovieView = checkOutMovieView;
    }

    @Override
    public void perform() {
        String movieName = checkOutMovieView.takeUserInputForCheckOutMovie();
        Movie movie = library.movieSearcher(movieName);
        library.checkOutMovie(movie);
        checkOutMovieView.displayMessage(movie.getAppropriateMessageOnCheckOutAction());
    }
}
