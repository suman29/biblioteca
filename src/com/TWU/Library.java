package com.twu;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> booksCheckedOut;
    private ArrayList<Book> booksAvailable;

    public Library(ArrayList<Book> booksCheckedOut, ArrayList<Book> booksAvailable) {
        this.booksCheckedOut = booksCheckedOut;
        this.booksAvailable = booksAvailable;
    }

    public void initialiseAvailableBooks() {
        new BooksView(new Books(booksAvailable));
    }

    public void initialiseCheckedOutBooks() {
        new BooksView(new Books(booksCheckedOut));
    }

    public boolean checkOutBook(int bookIndex) {
        try {

            Book checkedOut = booksAvailable.remove(bookIndex - 1);
            return booksCheckedOut.add(checkedOut);
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }

    public boolean returnBook(int bookIndex) {
        try {

            Book returnedBook = booksCheckedOut.remove(bookIndex - 1);
            return booksAvailable.add(returnedBook);
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }

    }
}
