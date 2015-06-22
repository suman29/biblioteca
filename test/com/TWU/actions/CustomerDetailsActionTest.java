package com.twu.actions;

import com.twu.users.Customer;
import com.twu.users.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class CustomerDetailsActionTest {
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void shouldBeAbleToDisplayCustomersDetails() {
        User user = new Customer("123-4567", "abcd", "name", "email", "123456789");
        CustomerDetailsAction customerDetailsAction = new CustomerDetailsAction();
        customerDetailsAction.perform(user);

        String actualOutput = outputStream.toString();
        String expectedOutput = "name                email               123456789" + System.lineSeparator();

        assertEquals(actualOutput, expectedOutput);
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }
}