package com.twu.movies;

import com.twu.users.Customer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {
    Customer customer = new Customer("","");
    @Test
    public void shouldRepresentMovieInProperFormat() {
        Movie movie = new CheckedOutMovies("Movie1", 2001, "abc", 1, customer);

        String actualOutput = movie.toString();
        String expectedOutput = "Movie1                                            abc                           2001 rating: 1";

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void shouldBeEqualToItself() {
        Movie firstMovie = new CheckedOutMovies("Movie1", 2001, "abc", 1, customer);
        boolean actual = firstMovie.equals(firstMovie);

        assertEquals(true, actual);
    }

    @Test
    public void shouldFollowSymmetricProperty() {
        Movie firstMovie = new CheckedOutMovies("Movie1", 2001, "abc", 1, customer);
        Movie secondMovie = new AvailableMovie("Movie1", 2001, "abc", 1);
        boolean actual = (firstMovie.equals(secondMovie) == secondMovie.equals(firstMovie));

        assertEquals(true, actual);
    }

    @Test
    public void shouldFollowTransitiveProperty() {
        Movie firstMovie = new CheckedOutMovies("Movie1", 2001, "abc", 1, customer);
        Movie secondMovie = new AvailableMovie("Movie1", 2001, "abc", 1);
        Movie thirdMovie = new CheckedOutMovies("Movie1", 2001, "abc", 1, customer);

        boolean actual = firstMovie.equals(secondMovie) &&
                secondMovie.equals(thirdMovie) &&
                firstMovie.equals(thirdMovie);

        assertEquals(true, actual);
    }

    @Test
    public void shouldHaveSameHashCodeIfMoviesAreEqual() {
        Movie firstMovie = new CheckedOutMovies("Movie1", 2001, "abc", 1, customer);
        Movie secondMovie = new AvailableMovie("Movie1", 2001, "abc", 1);


        boolean actual = firstMovie.equals(secondMovie) && (firstMovie.hashCode() == secondMovie.hashCode());

        assertEquals(true, actual);
    }
}