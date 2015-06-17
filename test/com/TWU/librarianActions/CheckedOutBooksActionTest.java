package com.twu.librarianActions;

import com.twu.Library;
import com.twu.books.Book;
import com.twu.users.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class CheckedOutBooksActionTest {

    @Mock
    Library library;

    @Mock
    Customer customer;

    @Test
    public void shouldGiveTheListOfCheckedOutBooksWithCustomerDetails(){
        ArrayList<Book> list= new ArrayList<>();
        CheckedOutBooksAction checkedOutBooksAction = new CheckedOutBooksAction(list, library);
        checkedOutBooksAction.perform(customer);

        verify(library).getCheckedOutBooks(list);
    }

}