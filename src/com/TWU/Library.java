package com.TWU;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    private ArrayList<String> booksAvailable;

    public Library(ArrayList<String> books) {
        this.booksAvailable = books;
    }

    public List<String> getBooksAvailable() {
        return Collections.unmodifiableList(booksAvailable);
    }
}