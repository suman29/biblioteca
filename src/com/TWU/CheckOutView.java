package com.twu;

import java.io.BufferedReader;
import java.io.IOException;

public class CheckOutView {

    private BufferedReader bufferedReader;
    private BooksView booksView;

    public CheckOutView(BufferedReader bufferedReader, BooksView booksView) {
        this.bufferedReader = bufferedReader;
        this.booksView = booksView;
    }

    public String takeUserInputForCheckOutBook() {
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

    public void displayListOfBooks() {
        booksView.displayListOfBooks();
    }

    public void displayBookCheckedOutSuccessfully() {
        System.out.println(Messages.CHECKOUT_SUCCESSFUL);
    }

    public void displayBookNotCheckedOutSuccessfully() {
        System.out.println(Messages.CHECKOUT_UNSUCCESSFUL);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
