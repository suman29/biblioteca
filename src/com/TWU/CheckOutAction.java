package com.twu;

public class CheckOutAction implements Option {

    private CheckOutView checkOutView;
    private Library library;

    public CheckOutAction(CheckOutView checkOutView, Library library) {
        this.checkOutView = checkOutView;
        this.library = library;
    }

    @Override
    public void perform() {
        String bookName = checkOutView.takeUserInputForCheckOutBook();
        Book book = library.bookSearcher(bookName);
        library.checkOutBook(book);
        book.getAppropriateMessageOnCheckOutAction();
    }
}
