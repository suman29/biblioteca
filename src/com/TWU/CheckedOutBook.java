package com.twu;

import java.util.ArrayList;

public class CheckedOutBook extends Book {

    public CheckedOutBook(String name, String author, int year, int id) {
        super(name, author, year, id);
    }

    @Override
    public void addItselfToAvailableListOfBookIfApplicable(ArrayList<Book> availableBooks) {
    }

    @Override
    public void getAppropriateMessageOnCheckOutAction() {
    }

    @Override
    public void getAppropriateMessageOnReturnBookAction() {
        System.out.println(Messages.RETURN_SUCCESSFUL);
    }

    @Override
    public void checkOut(ArrayList<Book> list) {

    }

    @Override
    public void returnBook(ArrayList<Book> allBooks) {
        allBooks.remove(this);
        allBooks.add(AvailableBook.create(this));
    }

    public static CheckedOutBook create(AvailableBook availableBook) {
        return new CheckedOutBook(availableBook.name, availableBook.author, availableBook.year, availableBook.id);
    }

}
