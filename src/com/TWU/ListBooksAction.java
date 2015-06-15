package com.twu;

public class ListBooksAction implements Option {
    BooksView booksView;

    public ListBooksAction(BooksView booksView) {
        this.booksView = booksView;
    }

    @Override
    public void perform() {
        booksView.displayListOfBooks();
    }
}
