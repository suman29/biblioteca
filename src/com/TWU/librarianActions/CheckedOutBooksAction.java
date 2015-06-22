package com.twu.librarianActions;

import com.twu.Library;
import com.twu.Messages;
import com.twu.books.Book;
import com.twu.menu.Option;
import com.twu.users.User;
import com.twu.views.LibrarianActionView;

// Its gives details of a checked out book, whenever librarian search for a particular book.

public class CheckedOutBooksAction implements Option {
    private Library library;
    private LibrarianActionView librarianActionView;

    public CheckedOutBooksAction(Library library, LibrarianActionView librarianActionView) {

        this.library = library;
        this.librarianActionView = librarianActionView;
    }

    @Override
    public void perform(User customer) {
        librarianActionView.displayMessage(Messages.ENTER_BOOK_NAME);
        String bookName = librarianActionView.takeUserInputToGetDetailsOfItem();
        Book book = library.checkedBookSearcher(bookName);
        librarianActionView.displayMessage(book.toString());
    }

    @Override
    public void perform() {

    }
}
