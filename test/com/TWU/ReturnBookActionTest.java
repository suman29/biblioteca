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

    @Mock
    Searcher searcher;

    @Mock
    CheckedOutBook book;

    @Test
    public void shouldBeAbleToReturnBook() {
        when(returnBookView.takeUserInputForReturningBook())
                .thenReturn("good");
        ReturnBookAction returnBookAction = new ReturnBookAction(library, returnBookView, searcher);

        returnBookAction.perform();
        verify(library).returnBook(null);
    }

}