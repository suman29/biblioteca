package com.TWU.Utils;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;

public class BookFileReaderTest {

    @Test
    public void checkThatBookListIsEmptyWhenFileIsNotAvailable() {
        String filePath = System.getProperty("user.dir") + File.separator + "BookList1.txt";
        BookFileReader bookFileReader = new BookFileReader(filePath);
        ArrayList<String> listOfBooks = bookFileReader.getListOfAvailableBooks();

        assertThat(listOfBooks, is(empty()));
    }

    @Test
    public void checkIfBooksAreBeingReadFromFile() {
        String filePath = System.getProperty("user.dir") + File.separator + "BookList.txt";
        BookFileReader bookFileReader = new BookFileReader(filePath);
        ArrayList<String> listOfBooks = bookFileReader.getListOfAvailableBooks();

        assertThat(listOfBooks, is(notNullValue()));
    }
}
