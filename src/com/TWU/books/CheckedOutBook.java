package com.twu.books;

import com.twu.Messages;
import com.twu.users.Customer;

import java.util.ArrayList;

public class CheckedOutBook extends Book {
    private Customer customer;

    public CheckedOutBook(String name, String author, int year, int id, Customer customer) {
        super(name, author, year, id);
        this.customer = customer;
    }

    @Override
    public void addItselfToAvailableListOfBookIfApplicable(ArrayList<Book> availableBooks) {
    }

    @Override
    public String getAppropriateMessageOnCheckOutAction() {
        return Messages.BOOK_ALREADY_CHECKED;
    }

    @Override
    public String getAppropriateMessageOnReturnBookAction() {
        return Messages.RETURN_SUCCESSFUL;
    }

    @Override
    public void checkOut(ArrayList<Book> list, Customer customer) {

    }

    @Override
    public void returnBook(ArrayList<Book> allBooks) {
        allBooks.remove(this);
        allBooks.add(AvailableBook.create(this));
    }

    @Override
    public void addItselfToCheckedOutListOfBooksIfApplicable(ArrayList<Book> checkedoutBooks) {
        checkedoutBooks.add(this);
    }

    public String toString(){
        return (id + ".  " + String.format("%-50s", name) + String.format("%-30s", author) + String.format("%-5s", year)+" Customer:"+customer.toString());
    }

    public static CheckedOutBook create(AvailableBook availableBook, Customer customer) {
        return new CheckedOutBook(availableBook.name, availableBook.author, availableBook.year, availableBook.id, customer);
    }

}
