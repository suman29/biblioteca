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
        checkOutView.displayListOfBooks();
        String bookName = checkOutView.takeUserInputForCheckOutBook();
        try {
            AvailableBook book = (AvailableBook) searcher.getBook(library.allBooks, bookName);
            library.checkOutBook(book);
            checkOutView.displayBookCheckedOutSuccessfully();
        } catch (Exception e) {
            checkOutView.displayBookNotCheckedOutSuccessfully();
        }

    }
}
