package com.twu.librarianActions;

import com.twu.books.AvailableBook;
import com.twu.books.Book;
import com.twu.books.CheckedOutBook;
import com.twu.users.Customer;
import org.junit.Test;

import java.util.ArrayList;

public class CheckedOutBooksActionTest {

    @Test
    public void shouldGiveTheListOfCheckedOutBooksWithCustomerDetails(){
        ArrayList<Book> books = new ArrayList<>();
        Book book1 = new CheckedOutBook("abc1","xyz1",1,1,new Customer("lmn1","pqr1"));
        Book book2 = new CheckedOutBook("abc2","xyz1",1,1,new Customer("lmn2","pqr1"));
        Book book3 = new AvailableBook("abc2","xyz1",1,1);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        CheckedOutBooksAction checkedOutBooksAction = new CheckedOutBooksAction(books);

    }

}