package com.twu.views;

import java.io.BufferedReader;
import java.io.IOException;

// It is a view which takes input and display output while checking out a movie.

public class CheckOutMovieView {
    private BufferedReader bufferedReader;

    public CheckOutMovieView(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public String takeUserInputForCheckOutMovie() {
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
