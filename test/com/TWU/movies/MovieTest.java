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

    @Test
    public void shouldBeEqualToItself() {
        Movie firstMovie = new Movie("Movie1", 2001, "abc", 1);
        boolean actual = firstMovie.equals(firstMovie);

        assertEquals(true, actual);
    }

    @Test
    public void shouldFollowSymmetricProperty() {
        Movie firstMovie = new Movie("Movie1", 2001, "abc", 1);
        Movie secondMovie = new Movie("Movie1", 2001, "abc", 1);
        boolean actual = (firstMovie.equals(secondMovie) == secondMovie.equals(firstMovie));

        assertEquals(true, actual);
    }

    @Test
    public void shouldFollowTransitiveProperty() {
        Movie firstMovie = new Movie("Movie1", 2001, "abc", 1);
        Movie secondMovie = new Movie("Movie1", 2001, "abc", 1);
        Movie thirdMovie = new Movie("Movie1", 2001, "abc", 1);

        boolean actual = firstMovie.equals(secondMovie) &&
                secondMovie.equals(thirdMovie) &&
                firstMovie.equals(thirdMovie);

        assertEquals(true, actual);
    }

    @Test
    public void shouldHaveSameHashCodeIfMoviesAreEqual() {
        Movie firstMovie = new Movie("Movie1", 2001, "abc", 1);
        Movie secondMovie = new Movie("Movie1", 2001, "abc", 1);


        boolean actual = firstMovie.equals(secondMovie) && (firstMovie.hashCode() == secondMovie.hashCode());

        assertEquals(true, actual);
    }
}