package com.twu.actions;

import com.twu.books.CheckOutView;
import com.twu.Library;
import com.twu.Option;
import com.twu.books.Book;

public class CheckOutBookAction implements Option {

    private CheckOutView checkOutView;
    private Library library;

    public CheckOutBookAction(CheckOutView checkOutView, Library library) {
        this.checkOutView = checkOutView;
        this.library = library;
    }

    @Override
    public void perform() {
        String bookName = checkOutView.takeUserInputForCheckOutBook();
        Book book = library.bookSearcher(bookName);
        library.checkOutBook(book);
        checkOutView.displayMessage(book.getAppropriateMessageOnCheckOutAction());
    }
}
