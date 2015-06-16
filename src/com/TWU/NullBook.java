package com.twu;

import java.util.ArrayList;

public class NullBook extends Book {
    public NullBook(String name, String author, int year, int id) {
        super(name, author, year, id);
    }

    @Override
    public void addItselfToAvailableListOfBooksIfApplicable(ArrayList<Book> availableBooks) {

    }

    @Override
    public void getAppropriateMessageOnCheckOutAction() {
        System.out.println(Messages.CHECKOUT_UNSUCCESSFUL);
    }

    @Override
    public void getAppropriateMessageOnReturnBookAction() {
        System.out.println(Messages.RETURN_UNSUCCESSFUL);
    }

    @Override
    public void checkOut(ArrayList<Book> list) {

    }

    @Override
    public void returnBook(ArrayList<Book> list) {

    }
}
