package com.TWU;

import com.TWU.Utils.BookFileReader;

import java.util.ArrayList;

public class Library {
    private ArrayList<String> booksAvailable;

    public Library(BookFileReader file) {
        this.booksAvailable = file.getListOfAvailableBooks();
    }

    public ArrayList<String> getBooksAvailable() {
        return booksAvailable;
    }
}
