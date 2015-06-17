package com.twu.books;

import com.twu.Messages;
import com.twu.users.Customer;

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
        return Messages.CHECKOUT_UNSUCCESSFUL;
    }

    @Override
    public String getAppropriateMessageOnReturnBookAction() {
        return Messages.RETURN_UNSUCCESSFUL;
    }

    @Override
    public void checkOut(ArrayList<Book> list, Customer customer) {

    }

    @Override
    public void returnBook(ArrayList<Book> list) {

    }
}
