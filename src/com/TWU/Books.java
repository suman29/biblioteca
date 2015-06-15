package com.twu;

import java.util.ArrayList;

public class Books {
    private ArrayList<Book> books;

    public Books(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        String list = "";
        for (Book book : books)
            list += book.toString() + System.lineSeparator();
        return list + System.lineSeparator();
    }
}
