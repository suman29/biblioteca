package com.twu.movies;

import java.io.BufferedReader;
import java.io.IOException;

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
}
