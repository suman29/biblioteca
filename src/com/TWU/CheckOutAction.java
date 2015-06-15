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
        checkOutView.displayListOfBooks();
        int bookIndex = checkOutView.takeUserInputForCheckOutBook();
        if (library.checkOutBook(bookIndex))
            checkOutView.displayBookCheckedOutSuccessfully();
        else
            checkOutView.displayBookNotCheckedOutSuccessfully();
    }
}
