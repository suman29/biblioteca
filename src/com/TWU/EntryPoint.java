package com.twu;

//Entry point of the App, it has MenuView, CustomerMenu and ConsoleOutput.

import com.twu.menu.CustomerMenu;
import com.twu.menu.LibrarianMenu;
import com.twu.menu.MenuView;
import com.twu.users.Customer;
import com.twu.users.User;

public class EntryPoint {

    private MenuView menuView;
    private CustomerMenu customerMenu;
    private ConsoleOutput consoleOutput;
    private LoginController loginController;
    private LibrarianMenu librarianMenu;

    public EntryPoint(MenuView menuView, CustomerMenu customerMenu, ConsoleOutput consoleOutput, LoginController loginController, LibrarianMenu librarianMenu) {
        this.menuView = menuView;
        this.customerMenu = customerMenu;
        this.consoleOutput = consoleOutput;
        this.loginController = loginController;
        this.librarianMenu = librarianMenu;
    }

    private void menuIteration() {
        int continueLoop;
        User user= loginController.login();
        if(user instanceof Customer)
        do {

            menuView.displayListOfMenu(customerMenu, user);
            continueLoop = menuView.takeUserInputForMainMenu();

            if (customerMenu.isValidInput(continueLoop))
                customerMenu.performAction(continueLoop);
            else
                menuView.errorMessage();
        } while (continueLoop > 0);

        else
            do {
                menuView.displayListOfMenu(librarianMenu, user);
                continueLoop = menuView.takeUserInputForMainMenu();

                if (librarianMenu.isValidInput(continueLoop))
                    librarianMenu.performAction(continueLoop);
                else
                    menuView.errorMessage();
            }while (continueLoop > 0);
    }

    public void start() {
        consoleOutput.displayWelcomeMessage();
        menuIteration();
    }

}
