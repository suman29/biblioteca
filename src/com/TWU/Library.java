package com.twu;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> booksCheckedOut;
    private ArrayList<Book> booksAvailable;

    public Library(ArrayList<Book> booksCheckedOut, ArrayList<Book> booksAvailable) {
        this.booksCheckedOut = booksCheckedOut;
        this.booksAvailable = booksAvailable;
    }

    public void checkOutBook(int bookIndex) {
        Book checkedOut = booksAvailable.remove(bookIndex-1);
        booksCheckedOut.add(checkedOut);
    }
}
