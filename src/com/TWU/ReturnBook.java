package com.twu;

public class ReturnBook implements Option{

    private Library library;
    ReturnBookView returnBookView;

    public ReturnBook(Library library, ReturnBookView returnBookView) {
        this.library = library;
        this.returnBookView = returnBookView;
    }

    @Override
    public void perform() {
        library.initialiseCheckedOutBooks();
        returnBookView.displayListOfBooks();
        int index =returnBookView.takeUserInputForReturningBook();

        library.returnBook(index);
    }
}
