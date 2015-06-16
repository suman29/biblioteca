package com.twu;

import java.util.ArrayList;

public class NullBook extends Book {
    public NullBook(String name, String author, int year, int id) {
        super(name, author, year, id);
    }

    @Override
    public void addItselfToAvailableListOfBooksIfApplicable(ArrayList<Book> availableBooks) {

    }
}
