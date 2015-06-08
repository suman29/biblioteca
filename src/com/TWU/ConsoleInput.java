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
            ConsoleOutput consoleOutput = new ConsoleOutput();
            int input = Integer.parseInt(br.readLine());
            if (input >= 1)
                return input;
            else {
                return 0;
            }
        } catch (IOException e) {
            return 0;
        }
    }
}
