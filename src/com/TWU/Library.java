package com.twu;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> booksCheckedOut;
    protected ArrayList<Book> booksAvailable;

    public Library(ArrayList<Book> booksCheckedOut, ArrayList<Book> booksAvailable) {
        this.booksCheckedOut = booksCheckedOut;
        this.booksAvailable = booksAvailable;
    }

    public void checkOutBook(AvailableBook book) {

             CheckedOutBook.create(book);
             book.addItselfToAvailableListOfBooksIfAppplicable(booksAvailable);
    }

    public void returnBook(CheckedOutBook book) {

        AvailableBook.create(book);
        book.addItselfToAvailableListOfBooksIfAppplicable(booksAvailable);
    }

}

