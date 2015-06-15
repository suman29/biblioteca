package com.twu;

public class BibliotecaApp {

    private MenuView menuView;
    private Menu menu;
    private ConsoleOutput consoleOutput;

    public BibliotecaApp(MenuView menuView, Menu menu, ConsoleOutput consoleOutput) {
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
