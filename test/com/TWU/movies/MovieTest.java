package com.twu.movies;

import com.twu.users.Customer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {
    String name = "ashray";
    String email = "123@yh.com";
    String number = "7205787250";
    Customer customer = new Customer("", "", name, email, number);

    @Test
    public void shouldRepresentMovieInProperFormat() {
        Movie movie = new AvailableMovie("Movie1", 2001, "abc", 1);

        String actualOutput = movie.toString();
        String expectedOutput = "Movie1                                            abc                           2001 rating: 1";

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void shouldBeEqualToItself() {
        Movie firstMovie = new CheckedOutMovie("Movie1", 2001, "abc", 1, customer);
        boolean actual = firstMovie.equals(firstMovie);

        assertEquals(true, actual);
    }

    @Test
    public void shouldFollowSymmetricProperty() {
        Movie firstMovie = new CheckedOutMovie("Movie1", 2001, "abc", 1, customer);
        Movie secondMovie = new AvailableMovie("Movie1", 2001, "abc", 1);
        boolean actual = (firstMovie.equals(secondMovie) == secondMovie.equals(firstMovie));

        assertEquals(true, actual);
    }

    @Test
    public void shouldFollowTransitiveProperty() {
        Movie firstMovie = new CheckedOutMovie("Movie1", 2001, "abc", 1, customer);
        Movie secondMovie = new AvailableMovie("Movie1", 2001, "abc", 1);
        Movie thirdMovie = new CheckedOutMovie("Movie1", 2001, "abc", 1, customer);

        boolean actual = firstMovie.equals(secondMovie) &&
                secondMovie.equals(thirdMovie) &&
                firstMovie.equals(thirdMovie);

        assertEquals(true, actual);
    }

    @Test
    public void shouldHaveSameHashCodeIfMoviesAreEqual() {
        Movie firstMovie = new CheckedOutMovie("Movie1", 2001, "abc", 1, customer);
        Movie secondMovie = new AvailableMovie("Movie1", 2001, "abc", 1);


        boolean actual = firstMovie.equals(secondMovie) && (firstMovie.hashCode() == secondMovie.hashCode());

        assertEquals(true, actual);
    }
}