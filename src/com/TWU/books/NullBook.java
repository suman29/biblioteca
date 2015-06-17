package com.twu.books;

import com.twu.Messages;

import java.util.ArrayList;

public class NullBook extends Book {
    public NullBook(String name, String author, int year, int id) {
        super(name, author, year, id);
    }

    @Override
    public void addItselfToAvailableListOfBookIfApplicable(ArrayList<Book> availableBooks) {

    }

    @Override
    public String getAppropriateMessageOnCheckOutAction() {
        System.out.println(Messages.CHECKOUT_UNSUCCESSFUL);
        return null;
    }

    @Override
    public String getAppropriateMessageOnReturnBookAction() {
        System.out.println(Messages.RETURN_UNSUCCESSFUL);
        return null;
    }

    @Override
    public void checkOut(ArrayList<Book> list) {

    }

    @Override
    public void returnBook(ArrayList<Book> list) {

    }
}
