package com.twu.books;

import com.twu.Messages;
import com.twu.users.Customer;

import java.util.ArrayList;

//It is a null book, created whenever user gives unexpected input.

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

    @Override
    public void addItselfToCheckedOutListOfBooksIfApplicable(ArrayList<Book> checkedoutBooks) {

    }

    public String toString(){
        return Messages.BOOK_NOT_FOUND_IN_LIBRARY;
    }
}
