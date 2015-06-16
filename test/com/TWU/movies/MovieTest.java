package com.twu.movies;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {
    @Test
    public void shouldRepresentMovieInProperFormat() {
        Movie movie = new Movie("Movie1", 2001, "abc", 1);

        String actualOutput = movie.toString();
        String expectedOutput = "Movie1                                            abc                           2001 rating: 1";

        assertEquals(expectedOutput, actualOutput);
    }
}