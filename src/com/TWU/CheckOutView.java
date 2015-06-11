package com.twu;

import java.io.BufferedReader;
import java.io.IOException;

public class CheckOutView {

    private BufferedReader bufferedReader;

    public CheckOutView(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public int takeUserInputForCheckOutBook() {
        try {
            int input = Integer.parseInt(bufferedReader.readLine());
            if (input > 0)
                return input;
            else
                return -1;
        } catch (IOException e) {
            return -1;
        }
    }
}
