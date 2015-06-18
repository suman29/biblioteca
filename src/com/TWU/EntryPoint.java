package com.twu;

//Entry point of the App, it has MenuView, CustomerMenu and ConsoleOutput.

import com.twu.menu.MainMenu;
import com.twu.menu.MenuView;

public class EntryPoint {

    private MenuView menuView;
    private ConsoleOutput consoleOutput;
    private MainMenu mainMenu;


    public EntryPoint(MenuView menuView, ConsoleOutput consoleOutput, MainMenu mainMenu) {
        this.menuView = menuView;
        this.consoleOutput = consoleOutput;
        this.mainMenu = mainMenu;
    }

    private void menuIteration() {
        int continueLoop;
        do{
            menuView.displayListOfMenu(mainMenu);
            continueLoop = menuView.takeUserInputForMainMenu();
            if (mainMenu.isValidInput(continueLoop))
                mainMenu.performAction(continueLoop);
            else
                menuView.errorMessage();
        } while (continueLoop < 5);

    }

    public void start() {
        consoleOutput.displayWelcomeMessage();
        menuIteration();
    }

}
