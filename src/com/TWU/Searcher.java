package com.twu;

import java.util.ArrayList;

public class Searcher {
    public Book getBook(ArrayList<Book> bookList, String name) {
        for (Book book : bookList) {
            if ((book.name).equals(name))
                return book;
        }
        return null;
    }
}
