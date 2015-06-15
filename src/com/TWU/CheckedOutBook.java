package com.twu;

import java.util.ArrayList;

public class CheckedOutBook extends Book {

    public CheckedOutBook(String name, String author, int year, int id) {
        super(name, author, year, id);
    }

    @Override
    public void addItselfToAvailableListOfBooksIfAppplicable(ArrayList<Book> availableBooks) {
    }

    public CheckedOutBook create(AvailableBook availableBook) {
        return new CheckedOutBook(availableBook.name, availableBook.author, availableBook.year, availableBook.id);
    }
}
