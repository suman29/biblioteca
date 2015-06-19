package com.twu.menu;

import com.twu.LoginController;
import com.twu.users.Customer;
import com.twu.users.Librarian;
import com.twu.users.User;

// It allows only librarian to log with the correct credentials.

public class LibrarianLogin implements Option {
    private LoginController loginController;
    private MenuView menuView;
    private LibrarianMenu librarianMenu;

    public LibrarianLogin(LoginController loginController, MenuView menuView, LibrarianMenu librarianMenu) {
        this.loginController = loginController;
        this.menuView = menuView;
        this.librarianMenu = librarianMenu;
    }

    @Override
    public void perform(User customer) {

    }

    @Override
    public void perform() {
      User user = loginController.login();
        if(user instanceof Customer){
            menuView.displayMessage(user.getAppropriateMessageWhenNotALibrarian());
            return;
        }

        int continueLoop;
        do {
            menuView.displayMessage(user.getAppropriateMessageOnLogin());
            menuView.displayListOfMenu(librarianMenu, user);
            continueLoop = menuView.takeUserInputForMainMenu();

            if (librarianMenu.isValidInput(continueLoop))
                librarianMenu.performAction(continueLoop, (Librarian) user);
            else
                menuView.errorMessage();
        } while (continueLoop < 3);
    }
}
