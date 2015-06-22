package com.twu.views;

import java.io.BufferedReader;
import java.io.IOException;

// It perform the input output operation for the librarian action.

public class LibrarianActionView {
    private BufferedReader bufferedReader;

    public LibrarianActionView(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public String takeUserInputToGetDetailsOfItem() {
        try {
            String input = bufferedReader.readLine();
            return input;
        } catch (IOException e) {
            return "";
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
