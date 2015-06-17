package com.twu.books;

import com.twu.users.Customer;

import java.util.ArrayList;
import java.util.List;

public abstract class Book {
    protected String name, author;
    protected int year;
    protected int id;

    public Book(String name, String author, int year, int id) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.id = id;
    }

    public String toString() {
        return (id + ".  " + String.format("%-50s", name) + String.format("%-30s", author) + String.format("%-5s", year));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        Book book = (Book) o;

        if (year != book.year) return false;
        if (id != book.id) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        return !(author != null ? !author.equals(book.author) : book.author != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + id;
        return result;
    }

    public abstract void addItselfToAvailableListOfBookIfApplicable(ArrayList<Book> availableBooks);

    public abstract String getAppropriateMessageOnCheckOutAction();

    public abstract String getAppropriateMessageOnReturnBookAction();

    public abstract void checkOut(ArrayList<Book> list, Customer customer);

    public abstract void returnBook(ArrayList<Book> list);

    public void addItselfToListIfTitleMatches(List<Book> matchedBooks, String bookName) {
        if(this.name.equalsIgnoreCase(bookName))
            matchedBooks.add(this);
    }
}
