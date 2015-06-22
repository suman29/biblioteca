package com.twu.menu;

import com.twu.LoginController;
import com.twu.users.Customer;
import com.twu.users.Librarian;
import com.twu.users.NullUser;
import com.twu.users.User;
import com.twu.views.MenuView;

// It allows only librarian to log with the correct credentials.

public class LibrarianLogin implements Option {
    private LoginController loginController;
    private MenuView menuView;
    private LibrarianMenu librarianMenu;
    private NullUser nullUser;

    public LibrarianLogin(LoginController loginController, MenuView menuView, LibrarianMenu librarianMenu, NullUser nullUser) {
        this.loginController = loginController;
        this.menuView = menuView;
        this.librarianMenu = librarianMenu;
        this.nullUser = nullUser;
    }

    @Override
    public void perform(User customer) {

    }

    @Override
    public void perform() {
        User user = loginController.login();
        if (user instanceof Customer) {
            menuView.displayMessage(user.getAppropriateMessageWhenNotALibrarian());
            return;
        }
        if (user instanceof NullUser) {
            menuView.displayMessage(user.getAppropriateMessageOnLogin());
            return;
        }
        int continueLoop;
        menuView.displayMessage(user.getAppropriateMessageOnLogin());
        do {
            menuView.displayListOfMenu(librarianMenu, user);
            continueLoop = menuView.takeUserInputForMainMenu();

            if (librarianMenu.isValidInput(continueLoop))
                librarianMenu.performAction(continueLoop, (Librarian) user);
            else
                menuView.errorMessage();
        } while (continueLoop < 3);
    }
}
