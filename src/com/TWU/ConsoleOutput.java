package com.twu;

// It is used to display the welcome message, when app starts.

public class ConsoleOutput {

    public void displayWelcomeMessage() {
        System.out.println(Messages.WELCOME_MESSAGE);
    }

    public void displayWhenInvalidMainMenuIsSelected() {
        System.out.print(Messages.ERROR_MESSAGE);
    }
}