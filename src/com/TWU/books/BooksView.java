package com.twu.books;

//Its a view to display the book details.

public class BooksView {
    private Books books;

    public BooksView(Books books) {
        this.books = books;
    }

    public void displayListOfBooks() {
        System.out.print(books.toString());
    }
}
