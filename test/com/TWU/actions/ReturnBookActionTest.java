package com.twu.actions;

import com.twu.Library;
import com.twu.books.AvailableBook;
import com.twu.books.Book;
import com.twu.views.ReturnBookView;
import com.twu.users.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReturnBookActionTest {
    @Mock
    Library library;

    @Mock
    ReturnBookView returnBookView;

    @Mock
    Book book1;

    @Mock
    Customer customer;

    @Test
    public void shouldBeAbleToReturnBook() {
        when(returnBookView.takeUserInputForReturningBook()).thenReturn("Good");
        ArrayList<Book> list = new ArrayList<>();
        Book book = new AvailableBook("", "", 0, 0);
        when(library.bookSearcher("Good"))
                .thenReturn(book);

        ReturnBookAction returnBookAction = new ReturnBookAction(library, returnBookView);
        returnBookAction.perform(customer);

        verify(library).returnBook(book);
    }

}