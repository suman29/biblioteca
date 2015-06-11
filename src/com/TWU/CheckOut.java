package com.twu;

public class CheckOut implements Option {

    private CheckOutView checkOutView;
    private Library library;

    public CheckOut(CheckOutView checkOutView, Library library) {
        this.checkOutView = checkOutView;
        this.library = library;
    }

    @Override
    public void perform() {
        checkOutView.displayListOfBooks();
        int bookIndex = checkOutView.takeUserInputForCheckOutBook();
        if(library.checkOutBook(bookIndex))
        checkOutView.displayBookCheckedOutSuccessfully();
        else
        checkOutView.displayBookNotCheckedOutSuccessfully();
    }
}
