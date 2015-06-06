package com.TWU;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    private ArrayList<Book> booksAvailable;

    public Library(ArrayList<Book> books) {
        this.booksAvailable = books;
    }

    public List<Book> getBooksAvailable() {
        return Collections.unmodifiableList(booksAvailable);
    }
}