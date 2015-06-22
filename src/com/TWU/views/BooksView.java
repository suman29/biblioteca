package com.twu.views;

//Its a view to display the book details.

import com.twu.books.Books;

public class BooksView {
    private Books books;

    public BooksView(Books books) {
        this.books = books;
    }

    public void displayListOfBooks() {
        System.out.print(books.toString());
    }
}
