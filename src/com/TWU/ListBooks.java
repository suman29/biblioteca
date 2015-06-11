package com.twu;

public class ListBooks implements Option {
    BooksView booksView;

    public ListBooks(BooksView booksView) {
        this.booksView = booksView;
    }

    @Override
    public void perform() {
        booksView.displayListOfBooks();
    }
}
