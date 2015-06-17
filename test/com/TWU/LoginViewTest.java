package com.twu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class LoginViewTest {
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

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

    @Test
    public void shouldGiveAPromptOfEnterLibraryNumber () {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        LoginView loginView = new LoginView(bufferedReader);
        loginView.displayPromptEnterLibraryNumber();

        String actualOutput = outputStream.toString();
        String expectedOutput = Messages.ENTER_LIBRARY_NUMBER+System.lineSeparator();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void shouldGiveAPromptOfEnterPassword() {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        LoginView loginView = new LoginView(bufferedReader);
        loginView.displayPromptEnterPassword();

        String actualOutput = outputStream.toString();
        String expectedOutput = Messages.ENTER_PASSWORD+System.lineSeparator();

        assertEquals(expectedOutput, actualOutput);
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }
}