package com.twu.movies;

public class Movie {
    private String name;
    private int year;
    private String director;
    private int rating;

    public Movie(String name, int year, String director, int rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String toString() {
        return (String.format("%-50s", name) + String.format("%-30s", director) + String.format("%-5s", year)+"rating: "+rating);
    }
}
