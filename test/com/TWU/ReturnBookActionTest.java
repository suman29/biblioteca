package com.twu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReturnBookActionTest {
    @Mock
    Library library;

    @Mock
    ReturnBookView returnBookView;

    @Test
    public void shouldBeAbleToReturnBook() {
        when(returnBookView.takeUserInputForReturningBook())
                .thenReturn(1);
        ReturnBookAction returnBookAction = new ReturnBookAction(library, returnBookView);

        returnBookAction.perform();
        verify(library).returnBook(1);
    }

}