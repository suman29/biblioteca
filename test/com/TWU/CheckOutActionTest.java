package com.twu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

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
        when(checkOutView.takeUserInputForCheckOutBook())
                .thenReturn("Book1");
        AvailableBook book = new AvailableBook("Book1", "abx", 1234, 2);
        CheckOutAction checkOutAction = new CheckOutAction(checkOutView, library, searcher);

        checkOutAction.perform();
        verify(library).checkOutBook(null);
    }

}