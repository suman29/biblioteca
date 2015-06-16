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
        String bookName = returnBookView.takeUserInputForReturningBook();

        Book book = searcher.getBook(library.getBooks(), bookName);
        library.returnBook(book);
        book.getAppropriateMessageOnReturnBookAction();
    }
}
