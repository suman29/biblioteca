package com.twu.movies;

import java.util.ArrayList;

public abstract class Movie {
    public String name;
    protected int year;
    protected String director;
    protected int rating;

    public Movie(String name, int year, String director, int rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String toString() {
        return (String.format("%-50s", name) + String.format("%-30s", director) + String.format("%-5s", year) + "rating: " + rating);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        Movie movie = (Movie) o;

        if (year != movie.year) return false;
        if (rating != movie.rating) return false;
        if (name != null ? !name.equals(movie.name) : movie.name != null) return false;
        return !(director != null ? !director.equals(movie.director) : movie.director != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + year;
        result = 31 * result + (director != null ? director.hashCode() : 0);
        result = 31 * result + rating;
        return result;
    }

    public abstract void checkOut(ArrayList<Movie> list);

    public abstract void returnMovie(ArrayList<Movie> list);

    public abstract void addItselfToAvailableListOfMovieIfApplicable(ArrayList<Movie> availableMovies);

    public abstract void getAppropriateMessageOnCheckOutAction();

    public abstract void getAppropriateMessageOnReturnMovieAction();
}
