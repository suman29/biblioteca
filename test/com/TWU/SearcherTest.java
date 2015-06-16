package com.twu;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SearcherTest {
    @Test
    public void shouldBeAbleToGiveTheDesiredBook() {
        Searcher searcher = new Searcher();
        AvailableBook availableBook = new AvailableBook("God", "helpMe", 2015, 2);
        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(new AvailableBook("god", "helpMe", 2015, 2));
        bookList.add(availableBook);

        String name = "God";
        AvailableBook expectedBook = availableBook;
        Book actualBook = searcher.getBook(bookList, name);

        assertEquals(expectedBook, actualBook);
    }

}