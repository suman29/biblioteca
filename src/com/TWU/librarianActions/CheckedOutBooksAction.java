package com.twu.librarianActions;

import com.twu.books.Book;

import java.util.ArrayList;

public class CheckedOutBooksAction {
    ArrayList<Book> books;

    public CheckedOutBooksAction(ArrayList<Book> books) {
        this.books = books;
    }
}
