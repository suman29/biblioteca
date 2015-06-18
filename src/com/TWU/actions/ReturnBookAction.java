package com.twu.actions;

import com.twu.Library;
import com.twu.books.Book;
import com.twu.books.ReturnBookView;
import com.twu.menu.Option;
import com.twu.users.User;

// It helps customer to return the book to library.

public class ReturnBookAction implements Option {

    private Library library;
    private ReturnBookView returnBookView;


    public ReturnBookAction(Library library, ReturnBookView returnBookView) {
        this.library = library;
        this.returnBookView = returnBookView;
    }

    @Override
    public void perform(User customer) {
        String bookName = returnBookView.takeUserInputForReturningBook();
        Book book = library.bookSearcher(bookName);
        library.returnBook(book);
        returnBookView.displayMessage(book.getAppropriateMessageOnReturnBookAction());
    }

    @Override
    public void perform() {

    }
}
