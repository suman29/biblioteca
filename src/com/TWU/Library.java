package com.twu;

import java.util.ArrayList;

public class Library {
    protected ArrayList<Book> allBooks;

    public Library(ArrayList<Book> allBooks) {
        this.allBooks = allBooks;
    }

    public void checkOutBook(Book book) {
        book.checkOut(allBooks);
    }

    public void returnBook(Book book) {
        book.returnBook(allBooks);
    }

    public ArrayList<Book> getAvailableBooks(ArrayList<Book> availableBooks) {
        availableBooks.clear();

        for (Book book : allBooks)
            book.addItselfToAvailableListOfBooksIfApplicable(availableBooks);

        return availableBooks;
    }

    public ArrayList<Book> getBooks() {
        return allBooks;
    }
}

