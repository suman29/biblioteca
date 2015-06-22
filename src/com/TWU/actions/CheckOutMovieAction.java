package com.twu.actions;

import com.twu.Library;
import com.twu.Messages;
import com.twu.menu.Option;
import com.twu.views.CheckOutMovieView;
import com.twu.movies.Movie;
import com.twu.users.Customer;
import com.twu.users.User;

// Allows customers to check out a movie.

public class CheckOutMovieAction implements Option {
    private Library library;
    private CheckOutMovieView checkOutMovieView;

    public CheckOutMovieAction(Library library, CheckOutMovieView checkOutMovieView) {
        this.library = library;
        this.checkOutMovieView = checkOutMovieView;
    }

    @Override
    public void perform(User customer) {
        checkOutMovieView.displayMessage(Messages.ENTER_MOVIE_NAME);
        String movieName = checkOutMovieView.takeUserInputForCheckOutMovie();
        Movie movie = library.movieSearcher(movieName);
        library.checkOutMovie(movie, (Customer) customer);
        checkOutMovieView.displayMessage(movie.getAppropriateMessageOnCheckOutAction());
    }

    @Override
    public void perform() {

    }
}
