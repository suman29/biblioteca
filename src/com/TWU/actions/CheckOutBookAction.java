package com.twu.actions;

import com.twu.Library;
import com.twu.Messages;
import com.twu.books.Book;
import com.twu.books.CheckOutView;
import com.twu.menu.Option;
import com.twu.users.Customer;
import com.twu.users.User;

// Allows customers to checkout a book.

public class CheckOutBookAction implements Option {

    private CheckOutView checkOutView;
    private Library library;

    public CheckOutBookAction(CheckOutView checkOutView, Library library) {
        this.checkOutView = checkOutView;
        this.library = library;
    }

    @Override
    public void perform(User customer) {
        checkOutView.displayMessage(Messages.ENTER_BOOK_NAME);
        String bookName = checkOutView.takeUserInputForCheckOutBook();
        Book book = library.bookSearcher(bookName);
        library.checkOutBook(book, (Customer) customer);
        checkOutView.displayMessage(book.getAppropriateMessageOnCheckOutAction());
    }

    @Override
    public void perform() {

    }
}
