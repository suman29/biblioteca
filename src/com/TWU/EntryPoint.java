package com.twu;

//Entry point of the App, it has MenuView, Menu and ConsoleOutput.

import com.twu.menu.Menu;
import com.twu.menu.MenuView;
import com.twu.users.User;

public class EntryPoint {

    private MenuView menuView;
    private Menu menu;
    private ConsoleOutput consoleOutput;
    private LoginController loginController;

    public EntryPoint(MenuView menuView, Menu menu, ConsoleOutput consoleOutput, LoginController loginController) {
        this.menuView = menuView;
        this.menu = menu;
        this.consoleOutput = consoleOutput;
        this.loginController = loginController;
    }

    private void menuIteration() {
        int continueLoop;

        do {
            User user= loginController.login();
            menuView.displayListOfMenu(menu,user);
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
