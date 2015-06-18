package com.twu;

import java.io.BufferedReader;

//It is used to take the input from the user while logging in and display the appropriate message.

public class LoginView {
    BufferedReader bufferedReader;

    public LoginView(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public String getUserInput() {
        try {
            String input = (bufferedReader.readLine());
            return input;

        } catch (Exception e) {
            return "";
        }
    }


    public void displayPromptEnterLibraryNumber() {
        System.out.println(Messages.ENTER_LIBRARY_NUMBER);
    }

    public void displayPromptEnterPassword() {
        System.out.println(Messages.ENTER_PASSWORD);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
