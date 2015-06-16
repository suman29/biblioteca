package com.twu;

import java.util.ArrayList;

public abstract class Book {
    protected String name, author;
    protected int year;
    protected int id;

    public Book(String name, String author, int year, int id) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.id = id;
    }

    public String toString() {
        return (id + ".  " + String.format("%-50s", name) + String.format("%-30s", author) + String.format("%-5s", year));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        Book book = (Book) o;

        if (year != book.year) return false;
        if (id != book.id) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        return !(author != null ? !author.equals(book.author) : book.author != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + id;
        return result;
    }

    public abstract void addItselfToAvailableListOfBooksIfApplicable(ArrayList<Book> availableBooks);
}
