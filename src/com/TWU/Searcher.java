package com.twu;

import java.util.ArrayList;

public class Searcher {
    public Book getBook(ArrayList<Book> bookList, String name) {
        for (Book book : bookList) {
            if ((book.name).equalsIgnoreCase(name))
                return book;
        }
        return bookList.get(0);
    }
}
