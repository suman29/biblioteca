package com.twu.actions;

import com.twu.Library;
import com.twu.books.Book;
import com.twu.books.CheckOutView;
import com.twu.books.CheckedOutBook;
import com.twu.users.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CheckOutBookActionTest {

    @Mock
    Library library;

    @Mock
    CheckOutView checkOutView;

    @Mock
    Customer customer;

    @Test
    public void shouldCheckOutBooks() {
        when(checkOutView.takeUserInputForCheckOutBook()).thenReturn("Good");
        Book book = new CheckedOutBook("", "", 0, 0, customer);
        when(library.bookSearcher("Good"))
                .thenReturn(book);

        CheckOutBookAction checkOutBookAction = new CheckOutBookAction(checkOutView, library);
        checkOutBookAction.perform(customer);

        verify(library).checkOutBook(book, customer);
    }

}