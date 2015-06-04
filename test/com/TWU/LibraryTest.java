package com.TWU;

import com.TWU.Utils.BookFileReader;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LibraryTest {

    @Test
    public void checkIfBooksAvailableIsNotNullAfterInitialisation() {
        BookFileReader bookFileReaderStub = mock(BookFileReader.class);

        ArrayList<String> listOfBooks = new ArrayList<>();
        listOfBooks.add("Book 1");
        listOfBooks.add("Book 2");
        listOfBooks.add("Book 3");
        when(bookFileReaderStub.getListOfAvailableBooks())
                .thenReturn(listOfBooks);
        Library library = new Library(bookFileReaderStub);

        ArrayList<String> actualListOfAvailableBooks = library.getBooksAvailable();
        assertThat(actualListOfAvailableBooks, is(notNullValue()));

    }

}