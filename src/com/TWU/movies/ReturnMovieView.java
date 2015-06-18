package com.twu.movies;

import java.io.BufferedReader;
import java.io.IOException;

// It is a view which is used to take input and display output while returning view.

public class ReturnMovieView {
    private BufferedReader bufferedReader;

    public ReturnMovieView(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public String takeUserInputForReturningMovie() {
        try {
            String input = bufferedReader.readLine();
            if (input != null)
                return input;
            else
                return null;
        } catch (IOException e) {
            return null;
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
