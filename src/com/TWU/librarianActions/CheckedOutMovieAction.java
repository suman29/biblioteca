package com.twu.librarianActions;

import com.twu.Library;
import com.twu.Option;
import com.twu.movies.Movie;
import com.twu.users.User;

public class CheckedOutMovieAction implements Option {
    private Library library;
    private LibrarianActionView librarianActionView;

    public CheckedOutMovieAction(Library library, LibrarianActionView librarianActionView) {
        this.library = library;
        this.librarianActionView = librarianActionView;
    }

    @Override
    public void perform(User customer) {
        String movieName= librarianActionView.takeUserInputToGetDetailsOfItem();
        Movie movie = library.movieSearcher(movieName);
        librarianActionView.displayMessage(movie.toString());
    }
}
