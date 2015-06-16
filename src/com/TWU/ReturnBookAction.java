package com.twu;

public class ReturnBookAction implements Option {

    private Library library;
    private ReturnBookView returnBookView;
    private Searcher searcher;

    public ReturnBookAction(Library library, ReturnBookView returnBookView, Searcher searcher) {
        this.library = library;
        this.returnBookView = returnBookView;
        this.searcher = searcher;
    }

    @Override
    public void perform() {
        returnBookView.displayListOfBooks();
        String bookName = returnBookView.takeUserInputForReturningBook();

        try {
            CheckedOutBook book = (CheckedOutBook) searcher.getBook(library.allBooks, bookName);
            library.returnBook(book);
            returnBookView.displayBookReturnedSuccessfully();
        } catch (Exception e) {
            returnBookView.displayMessageWhenBookNotReturnedSuccessfully();
        }
    }
}
