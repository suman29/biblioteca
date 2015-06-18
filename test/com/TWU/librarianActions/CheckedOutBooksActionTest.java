package com.twu.librarianActions;

import com.twu.Library;
import com.twu.books.Book;
import com.twu.books.CheckedOutBook;
import com.twu.users.Customer;
import com.twu.users.Librarian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class CheckedOutBooksActionTest {
    @Mock
    Library library;
    @Mock
    Customer customer;
    @Mock
    LibrarianActionView librarianActionView;
    private Book book;
    private PrintStream out;

    @Before
    public void setUp() throws Exception {
        book = new CheckedOutBook("Name", "Author", 2000, 1, customer);
        out = new PrintStream(new ByteArrayOutputStream());
        System.setOut(out);
    }

    @Test
    public void shouldGiveTheListOfCheckedOutBooksWithCustomerDetails() {
        CheckedOutBooksAction checkedOutBooksAction = new CheckedOutBooksAction(library,librarianActionView);
        when(librarianActionView.takeUserInputToGetDetailsOfItem())
                .thenReturn("good");
        when(library.bookSearcher("good")).thenReturn(book);
        checkedOutBooksAction.perform(new Librarian("",""));

        verify(library).bookSearcher("good");
    }

}