package com.twu;

import java.util.ArrayList;

public class AvailableBook extends Book {
    public AvailableBook(String name, String author, int year, int id) {
        super(name, author, year, id);
    }

    @Override
    public void addItselfToAvailableListOfBooksIfApplicable(ArrayList<Book> availableBooks) {
        availableBooks.add(this);
    }

    @Override
    public void getAppropriateMessageOnCheckOutAction() {
        System.out.println(Messages.CHECKOUT_SUCCESSFUL);
    }

    @Override
    public void getAppropriateMessageOnReturnBookAction() {

    }

    public static AvailableBook create(CheckedOutBook checkedOutBook) {
        return new AvailableBook(checkedOutBook.name, checkedOutBook.author, checkedOutBook.year, checkedOutBook.id);
    }

    public void checkOut(ArrayList<Book> allBooks) {
        allBooks.remove(this);
        allBooks.add(CheckedOutBook.create(this));
    }
}
