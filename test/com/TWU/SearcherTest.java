package com.twu;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SearcherTest {

    @Test
    public void shouldBeAbleToGiveTheDesiredBook() {
        AvailableBook availableBook = new AvailableBook("Good", "helpMe", 2015, 2);
        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(new AvailableBook("Hello", "helpMe", 2015, 2));
        bookList.add(availableBook);
        Searcher searcher = new Searcher();

        String name = "Good";
        AvailableBook expectedBook = availableBook;
        Book actualBook = searcher.searchBook(bookList, name);

        assertEquals(expectedBook, actualBook);
    }

}