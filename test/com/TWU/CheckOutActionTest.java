package com.twu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CheckOutActionTest {

    @Mock
    Library library;

    @Mock
    CheckOutView checkOutView;

    @Test
    public void shouldCheckOutBooks() {
        when(checkOutView.takeUserInputForCheckOutBook()).thenReturn("Good");
        ArrayList<Book> list = new ArrayList<>();
        Book book = new CheckedOutBook("", "", 0, 0);
        when(library.bookSearcher("Good"))
                .thenReturn(book);

        CheckOutAction checkOutAction = new CheckOutAction(checkOutView, library);
        checkOutAction.perform();

        verify(library).checkOutBook(book);
    }

}