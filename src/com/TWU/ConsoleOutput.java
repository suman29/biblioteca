package com.twu;

public class ConsoleOutput {

    public void displayWelcomeMessage() {
        System.out.println(Messages.WELCOME_MESSAGE);
    }

    public void displayWhenInvalidMainMenuIsSelected() {
        System.out.print(Messages.ERROR_MESSAGE);
    }
}