package com.twu;

public class Book {
    private String name, author;
    private int year;
    private int id;

    public Book(String name, String author, int year, int id) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.id = id;
    }

    @Override
    public String toString() {
        return (id+".  "+String.format("%-50s", name) + String.format("%-30s", author) + String.format("%-5s", year));
    }
}
