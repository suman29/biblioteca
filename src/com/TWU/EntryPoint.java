package com.twu;

//Entry point of the App, it has MenuView, Menu and ConsoleOutput.

import com.twu.menu.Menu;
import com.twu.menu.MenuView;

public class EntryPoint {

    private MenuView menuView;
    private Menu menu;
    private ConsoleOutput consoleOutput;

    public EntryPoint(MenuView menuView, Menu menu, ConsoleOutput consoleOutput) {
        this.menuView = menuView;
        this.menu = menu;
        this.consoleOutput = consoleOutput;
    }

    private void menuIteration() {
        int continueLoop;

        do {
            menuView.displayListOfMenu(menu);
            continueLoop = menuView.takeUserInputForMainMenu();

            if (menu.isValidInput(continueLoop))
                menu.performAction(continueLoop);
            else
                menuView.errorMessage();
        } while (continueLoop > 0);
    }

    public void start() {
        consoleOutput.displayWelcomeMessage();
        menuIteration();
    }

}
