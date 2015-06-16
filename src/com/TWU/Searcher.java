package com.twu;

import java.util.ArrayList;

public class Searcher {
    ArrayList<Book> allBooks;

    public Searcher() {
        this.allBooks= null;
    }

    public Book searchBook(ArrayList<Book> allBooks, String bookName) {
        for (Book book : allBooks) {
            if ((book.name).equalsIgnoreCase(bookName))
                return book;
        }
        return allBooks.get(0);
    }
}
