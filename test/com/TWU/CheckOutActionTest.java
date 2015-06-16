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

    @Mock
    Searcher searcher;

    @Test
    public void shouldCheckOutBooks() {
        when(checkOutView.takeUserInputForCheckOutBook()).thenReturn("Good");
        ArrayList<Book> list = new ArrayList<>();
        Book book = new CheckedOutBook("", "", 0, 0);
        when(searcher.getBook(list, "Good"))
                .thenReturn(book);

        CheckOutAction checkOutAction = new CheckOutAction(checkOutView,library, searcher);
        checkOutAction.perform();

        verify(library).checkOutBook(book);
    }

}