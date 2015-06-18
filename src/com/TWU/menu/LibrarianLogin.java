package com.twu.menu;

import com.twu.LoginController;
import com.twu.users.User;

public class LibrarianLogin implements MainOption {
    private LoginController loginController;
    private MenuView menuView;
    private LibrarianMenu librarianMenu;

    public LibrarianLogin(LoginController loginController, MenuView menuView, LibrarianMenu librarianMenu) {
        this.loginController = loginController;
        this.menuView = menuView;
        this.librarianMenu = librarianMenu;
    }

    @Override
    public void perform() {
        User user = loginController.login();
        int continueLoop;
        do {
            menuView.displayListOfMenu(librarianMenu, user);
            continueLoop = menuView.takeUserInputForMainMenu();

            if (librarianMenu.isValidInput(continueLoop))
                librarianMenu.performAction(continueLoop);
            else
                menuView.errorMessage();
        } while (continueLoop < 3);
    }
}
