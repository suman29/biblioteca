package com.TWU;

public class ListBooks implements Options {
    BooksView booksView;

    public ListBooks(BooksView booksView) {
        this.booksView = booksView;
    }

    @Override
    public void perform() {
        booksView.displayListOfBooks();
    }
}
