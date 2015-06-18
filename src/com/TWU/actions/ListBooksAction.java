package com.twu.actions;

import com.twu.Library;
import com.twu.books.Book;
import com.twu.menu.Option;
import com.twu.users.User;

import java.util.ArrayList;

public class ListBooksAction implements Option {
    private ArrayList<Book> availableBooks;
    private Library library;

    public ListBooksAction(ArrayList<Book> availableBooks, Library library) {
        this.availableBooks = availableBooks;
        this.library = library;
    }

    @Override
    public void perform(User customer) {
        library.getAvailableBooks(availableBooks);
        for (Book book : availableBooks)
            System.out.println(book.toString());
    }

    @Override
    public void perform() {
        library.getAvailableBooks(availableBooks);
        for (Book book : availableBooks)
            System.out.println(book.toString());
    }
}
