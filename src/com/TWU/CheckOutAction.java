package com.twu;

public class CheckOutAction implements Option {

    private CheckOutView checkOutView;
    private Library library;
    private Searcher searcher;

    public CheckOutAction(CheckOutView checkOutView, Library library, Searcher searcher) {
        this.checkOutView = checkOutView;
        this.library = library;
        this.searcher = searcher;
    }

    @Override
    public void perform() {
        String bookName = checkOutView.takeUserInputForCheckOutBook();
        Book book = searcher.getBook(library.getBooks(), bookName);
        library.checkOutBook(book);
        book.getAppropriateMessageOnCheckOutAction();
    }
}
