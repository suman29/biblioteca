package com.twu;

import java.io.BufferedReader;

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
