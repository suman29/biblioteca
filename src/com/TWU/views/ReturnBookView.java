package com.twu.views;

import com.twu.Messages;

import java.io.BufferedReader;
import java.io.IOException;

// It is a view created to take input and display output during the return book action.

public class ReturnBookView {
    private BufferedReader bufferedReader;
    private BooksView booksView;

    public ReturnBookView(BufferedReader bufferedReader, BooksView booksView) {
        this.bufferedReader = bufferedReader;
        this.booksView = booksView;
    }

    public String takeUserInputForReturningBook() {
        try {
            String input = (bufferedReader.readLine());
            if (input != null)
                return input;
            else
                return null;
        } catch (IOException e) {
            return null;
        }
    }

    public void displayListOfBooks() {
        booksView.displayListOfBooks();
    }

    public void displayBookReturnedSuccessfully() {
        System.out.println(Messages.RETURN_SUCCESSFUL);
    }

    public void displayMessageWhenBookNotReturnedSuccessfully() {
        System.out.println(Messages.RETURN_UNSUCCESSFUL);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
