package com.twu;

import java.util.ArrayList;

public class Library {

    protected ArrayList<Book> booksAvailable;

    public Library(ArrayList<Book> booksAvailable) {
        this.booksAvailable = booksAvailable;
    }

    public void checkOutBook(AvailableBook book) {
        CheckedOutBook.create(book);
    }

    public void returnBook(CheckedOutBook book) {
        AvailableBook.create(book);
    }

}

