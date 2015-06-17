package com.twu.librarianActions;

import com.twu.Library;
import com.twu.Option;
import com.twu.books.Book;
import com.twu.users.User;

import java.util.ArrayList;

public class CheckedOutBooksAction implements Option {
    ArrayList<Book> books;
    private Library library;

    public CheckedOutBooksAction(ArrayList<Book> books, Library library) {
        this.books = books;
        this.library = library;
    }

    @Override
    public void perform(User customer) {
        library.getCheckedOutBooks(books);
        for (Book book : books)
            System.out.println(book.toString());
    }
}
