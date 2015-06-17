package com.twu.users;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserTest {

    @Test
    public void shouldDisplayTheUserNumberProperly() {
        User user = new Customer("123-4567", "abcd");

        String actualOutput = user.toString();
        String expectedOutput = "123-4567" + System.lineSeparator();

        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void shouldBeEqualToItself() {
        User firstUser = new Customer("abc", "xyz");

        boolean actual = firstUser.equals(firstUser);

        assertEquals(true, actual);
    }

    @Test
    public void shouldFollowSymmetricProperty() {
        User firstUser = new Customer("abc", "xyz");
        User secondUser = new Librarian("abc", "xyz");

        boolean actual = (firstUser.equals(secondUser) == secondUser.equals(firstUser));

        assertEquals(true, actual);
    }

    @Test
    public void shouldFollowTransitiveProperty() {
        User firstUser = new Customer("abc", "xyz");
        User secondUser = new Librarian("abc", "xyz");
        User thirdUser = new Librarian("abc", "xyz");

        boolean actual = firstUser.equals(secondUser) &&
                secondUser.equals(thirdUser) &&
                firstUser.equals(thirdUser);

        assertEquals(true, actual);
    }

    @Test
    public void shouldHaveSameHashCodeIfUsersAreEqual() {
        User firstUser = new Customer("abc", "xyz");
        User secondUser = new Librarian("abc", "xyz");

        boolean actual = firstUser.equals(secondUser) && (firstUser.hashCode() == secondUser.hashCode());

        assertEquals(true, actual);
    }

    @Test
    public void shouldAddToListIfValidUser() {
        User firstUser = new Customer("abc", "xyz");
        ArrayList<User> list = new ArrayList<>();

        firstUser.addToListIfCredentialsMatch(list, "abc","xyz");

        assertTrue(list.contains(firstUser));
    }
}