package com.twu.books;

import com.twu.users.Customer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    @Test
    public void checkIfTheBookDetailsAreBeingRepresentedInOneLine() {
        String name = "Introduction to Algorithms";
        String author = "John";
        int year = 1920;
        int id = 1;
        Book book = new AvailableBook(name, author, year, id);

        String actualFormat = book.toString();
        String expectedFormat = "1.  Introduction to Algorithms                        John                          1920 ";

        assertEquals(actualFormat, expectedFormat);
    }

    @Test
    public void shouldBeEqualToItself() {
        AvailableBook firstBook = new AvailableBook("book1", "ashray", 1990, 1);

        boolean actual = firstBook.equals(firstBook);

        assertEquals(true, actual);
    }

    @Test
    public void shouldFollowSymmetricProperty() {
        AvailableBook firstBook = new AvailableBook("book1", "ashray", 1990, 1);
        CheckedOutBook secondBook = new CheckedOutBook("book1", "ashray", 1990, 1, new Customer("",""));

        boolean actual = (firstBook.equals(secondBook) == secondBook.equals(firstBook));

        assertEquals(true, actual);
    }

    @Test
    public void shouldFollowTransitiveProperty() {
        AvailableBook firstBook = new AvailableBook("book1", "ashray", 1990, 1);
        CheckedOutBook secondBook = new CheckedOutBook("book1", "ashray", 1990, 1, new Customer("",""));
        AvailableBook thirdBook = new AvailableBook("book1", "ashray", 1990, 1);

        boolean actual = firstBook.equals(secondBook) &&
                secondBook.equals(thirdBook) &&
                firstBook.equals(thirdBook);

        assertEquals(true, actual);
    }

    @Test
    public void shouldHaveSameHashCodeIfBooksAreEqual() {
        AvailableBook firstBook = new AvailableBook("book1", "ashray", 1990, 1);
        CheckedOutBook secondBook = new CheckedOutBook("book1", "ashray", 1990, 1, new Customer("",""));

        boolean actual = firstBook.equals(secondBook) && (firstBook.hashCode() == secondBook.hashCode());

        assertEquals(true, actual);
    }
}
