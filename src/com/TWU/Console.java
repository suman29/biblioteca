package com.TWU;

import java.util.List;

public class Console {

    public void displayWelcomeMessage() {
        System.out.println("Welcome");
    }

    public void displayListOfBooks(List<Book> bookList) {
        for (Book book : bookList) {
            System.out.println(book.toString());
        }
    }
}