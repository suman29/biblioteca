package com.twu;

import java.io.BufferedReader;
import java.io.IOException;

public class CheckOutView {

    private BufferedReader bufferedReader;
    private BooksView booksView;

    public CheckOutView(BufferedReader bufferedReader,BooksView booksView) {
        this.bufferedReader = bufferedReader;
        this.booksView = booksView;
    }

    public int takeUserInputForCheckOutBook() {
        try {
            int input = Integer.parseInt(bufferedReader.readLine());
            if (input > 0)
                return input;
            else
                return -1;
        } catch (IOException e) {
            return -1;
        }
    }

    public void displayListOfBooks() {
        booksView.displayListOfBooks();
    }
}
