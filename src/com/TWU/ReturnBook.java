package com.twu;

public class ReturnBook implements Option {

    private Library library;
    ReturnBookView returnBookView;

    public ReturnBook(Library library, ReturnBookView returnBookView) {
        this.library = library;
        this.returnBookView = returnBookView;
    }

    @Override
    public void perform() {
        returnBookView.displayListOfBooks();
        int index = returnBookView.takeUserInputForReturningBook();
        if (library.returnBook(index))
            returnBookView.displayBookReturnedSuccessfully();
        else
            returnBookView.displayMessageWhenBookNotReturnedSuccessfully();
    }
}
