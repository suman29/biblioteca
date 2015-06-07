package com.TWU;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput {
    private BufferedReader br;

    public ConsoleInput() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public int takeUserInputForMainMenu() {
        try {
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            return 0;
        }
    }
}
