package com.twu.books;

import com.twu.Messages;

import java.util.ArrayList;

public class AvailableBook extends Book {
    public AvailableBook(String name, String author, int year, int id) {
        super(name, author, year, id);
    }

    @Override
    public void addItselfToAvailableListOfBookIfApplicable(ArrayList<Book> availableBooks) {
        availableBooks.add(this);
    }

    @Override
    public String getAppropriateMessageOnCheckOutAction() {
        return Messages.CHECKOUT_SUCCESSFUL;
    }

    @Override
    public String getAppropriateMessageOnReturnBookAction() {
        return Messages.BOOK_ALREADY_AVAILABLE;
    }

    public static AvailableBook create(CheckedOutBook checkedOutBook) {
        return new AvailableBook(checkedOutBook.name, checkedOutBook.author, checkedOutBook.year, checkedOutBook.id);
    }

    public void checkOut(ArrayList<Book> allBooks) {
        allBooks.remove(this);
        allBooks.add(CheckedOutBook.create(this));
    }

    @Override
    public void returnBook(ArrayList<Book> list) {

    }
}
