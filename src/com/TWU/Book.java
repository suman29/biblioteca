package com.twu;

public class Book {
    private String name, author;
    private int year;

    public Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return (String.format("%-50s", name) + String.format("%-30s", author) + String.format("%-5s", year));
    }
}
