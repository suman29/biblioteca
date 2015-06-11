package com.twu;

public class BibliotecaSetUp {

    private MenuView menuView;
    private Menu menu;
    private int continueLoop;
    private ConsoleOutput consoleOutput;

    public BibliotecaSetUp(MenuView menuView, Menu menu, int continueLoop, ConsoleOutput consoleOutput) {
        this.menuView = menuView;
        this.menu = menu;
        this.continueLoop = continueLoop;
        this.consoleOutput = consoleOutput;
    }

    private void menuIteration() {
        while (continueLoop > 0) {
            menuView.displayListOfMenu(menu);
            continueLoop = menuView.takeUserInputForMainMenu();
            if (menu.isValidInput(continueLoop))
                menu.performAction(continueLoop);
            else
                menuView.errorMessage();
        }
    }

    public void start() {
        consoleOutput.displayWelcomeMessage();
        menuIteration();
    }

}
