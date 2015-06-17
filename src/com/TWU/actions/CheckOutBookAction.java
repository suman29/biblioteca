package com.twu.actions;

import com.twu.Library;
import com.twu.Option;
import com.twu.books.Book;
import com.twu.books.CheckOutView;
import com.twu.users.Customer;
import com.twu.users.User;

public class CheckOutBookAction implements Option {

    private CheckOutView checkOutView;
    private Library library;

    public CheckOutBookAction(CheckOutView checkOutView, Library library) {
        this.checkOutView = checkOutView;
        this.library = library;
    }

    @Override
    public void perform(User customer) {
        String bookName = checkOutView.takeUserInputForCheckOutBook();
        Book book = library.bookSearcher(bookName);
        library.checkOutBook(book, (Customer) customer);
        checkOutView.displayMessage(book.getAppropriateMessageOnCheckOutAction());
    }
}
