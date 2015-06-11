package com.twu;

import java.io.BufferedReader;
import java.io.IOException;

public class CheckOutView {

    private BufferedReader bufferedReaderr;

    public CheckOutView(BufferedReader bufferedReader) {
        this.bufferedReaderr = bufferedReader;
    }

    public int takeUserInputForCheckOutBook() {
        try {
            int input = Integer.parseInt(bufferedReaderr.readLine());
            if (input > 0)
                return input;
            else
                return -1;
        } catch (IOException e) {
            return -1;
        }
    }
}
