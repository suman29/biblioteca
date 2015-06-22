package com.twu.users;

import com.twu.Messages;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserTest {

    String name = "ashray";
    String email = "123@yh.com";
    String number = "7205787250";

    @Test
    public void shouldDisplayTheUserNumberProperly() {
        User user = new Librarian("123-4567", "abcd");

        String actualOutput = user.toString();
        String expectedOutput = "123-4567" + System.lineSeparator();

        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void shouldDisplayMessageIfNotAValidLibrarian() {
        User user = new Customer("123-4567", "abcd", name, email, number);

        String actualOutput = user.getAppropriateMessageWhenNotALibrarian();
        String expectedOutput = Messages.NOT_A_VALID_LIBRARIAN;

        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void shouldBeEqualToItself() {
        User firstUser = new Customer("abc", "xyz", name, email, number);

        boolean actual = firstUser.equals(firstUser);

        assertEquals(true, actual);
    }

    @Test
    public void shouldFollowSymmetricProperty() {
        User firstUser = new Customer("abc", "xyz", name, email, number);
        User secondUser = new Librarian("abc", "xyz");

        boolean actual = (firstUser.equals(secondUser) == secondUser.equals(firstUser));

        assertEquals(true, actual);
    }

    @Test
    public void shouldFollowTransitiveProperty() {
        User firstUser = new Customer("abc", "xyz", name, email, number);
        User secondUser = new Librarian("abc", "xyz");
        User thirdUser = new Librarian("abc", "xyz");

        boolean actual = firstUser.equals(secondUser) &&
                secondUser.equals(thirdUser) &&
                firstUser.equals(thirdUser);

        assertEquals(true, actual);
    }

    @Test
    public void shouldHaveSameHashCodeIfUsersAreEqual() {
        User firstUser = new Customer("abc", "xyz", name, email, number);
        User secondUser = new Librarian("abc", "xyz");

        boolean actual = firstUser.equals(secondUser) && (firstUser.hashCode() == secondUser.hashCode());

        assertEquals(true, actual);
    }

    @Test
    public void shouldAddToListIfValidUser() {
        User firstUser = new Customer("abc", "xyz", name, email, number);
        ArrayList<User> list = new ArrayList<>();

        firstUser.addToListIfCredentialsMatch(list, "abc", "xyz");

        assertTrue(list.contains(firstUser));
    }
}