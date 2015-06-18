package com.twu.librarianActions;

import java.io.BufferedReader;
import java.io.IOException;

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
