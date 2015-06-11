package com.twu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CheckOutTest {

    @Mock
    Library library;

    @Mock
    CheckOutView checkOutView;

    @Test
    public void shouldCheckOutBooks() {
        when(checkOutView.takeUserInputForCheckOutBook())
                .thenReturn(1);
        CheckOut checkOut = new CheckOut(checkOutView, library);

        checkOut.perform();
        verify(library).checkOutBook(1);
    }

}