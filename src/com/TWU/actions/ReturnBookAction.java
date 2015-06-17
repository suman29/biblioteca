package com.twu.actions;

import com.twu.Library;
import com.twu.Option;
import com.twu.books.ReturnBookView;
import com.twu.books.Book;

public class ReturnBookAction implements Option {

    private Library library;
    private ReturnBookView returnBookView;


    public ReturnBookAction(Library library, ReturnBookView returnBookView) {
        this.library = library;
        this.returnBookView = returnBookView;
    }

    @Override
    public void perform() {
        String bookName = returnBookView.takeUserInputForReturningBook();
        Book book = library.bookSearcher(bookName);
        library.returnBook(book);
        returnBookView.displayMessage(book.getAppropriateMessageOnReturnBookAction());
    }
}
