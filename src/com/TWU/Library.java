package com.twu;

import java.util.ArrayList;

public class Library {

    protected ArrayList<Book> allBooks;

    public Library(ArrayList<Book> allBooks) {
        this.allBooks = allBooks;
    }

    public void checkOutBook(AvailableBook book) {
        book.checkOut(allBooks);
    }

    public void returnBook(CheckedOutBook book) {
        book.makeAvailableInLibrary(allBooks);
    }

    public ArrayList<Book> getAvailableBooks(ArrayList<Book> availableBooks) {
        availableBooks.clear();

        for (Book book : allBooks)
            book.addItselfToAvailableListOfBooksIfApplicable(availableBooks);

        return availableBooks;
    }

}

