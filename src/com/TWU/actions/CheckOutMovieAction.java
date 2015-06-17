package com.twu.actions;

import com.twu.Library;
import com.twu.Option;
import com.twu.movies.CheckOutMovieView;
import com.twu.movies.Movie;
import com.twu.users.Customer;
import com.twu.users.User;

public class CheckOutMovieAction implements Option {
    private Library library;
    private CheckOutMovieView checkOutMovieView;

    public CheckOutMovieAction(Library library, CheckOutMovieView checkOutMovieView) {
        this.library = library;
        this.checkOutMovieView = checkOutMovieView;
    }

    @Override
    public void perform(User customer) {
        String movieName = checkOutMovieView.takeUserInputForCheckOutMovie();
        Movie movie = library.movieSearcher(movieName);
        library.checkOutMovie(movie, (Customer) customer);
        checkOutMovieView.displayMessage(movie.getAppropriateMessageOnCheckOutAction());
    }
}
