package com.twu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReturnBookTest {
    @Mock
    Library library;

    @Mock
    ReturnBookView returnBookView;

    @Test
    public void shouldBeAbleToReturnBook() {
        when(returnBookView.takeUserInputForReturningBook())
                .thenReturn(1);
        ReturnBook returnBook = new ReturnBook(library, returnBookView);

        returnBook.perform();
        verify(library).returnBook(1);
    }

}