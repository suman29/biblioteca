package com.TWU;

import java.util.ArrayList;

public class Library {
    private ArrayList<String> booksAvailable;

    public Library(ArrayList<String> books) {
        this.booksAvailable = books;
    }

    public ArrayList<String> getBooksAvailable() {
        return booksAvailable;
    }
}