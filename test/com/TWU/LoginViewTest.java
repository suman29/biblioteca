package com.twu;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;

public class LoginViewTest {

    @Test
    public void shouldTakeUserInputAsALibraryNumber() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("hi".getBytes());
        System.setIn(byteArrayInputStream);
        InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        LoginView loginView = new LoginView(bufferedReader);

        String expectedOutput = loginView.getUserInput();
        String actualOutput = "hi";

        assertEquals(expectedOutput, actualOutput);
    }

}