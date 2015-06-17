package com.twu;

import java.io.BufferedReader;

public class LoginView {
    BufferedReader bufferedReader;

    public LoginView(BufferedReader bufferedReader) {
        this.bufferedReader=bufferedReader;
    }

    public String getUserInput() {
        try {
            String input = (bufferedReader.readLine());
            return input;

        } catch (Exception e) {
            return "";
        }
    }

}
