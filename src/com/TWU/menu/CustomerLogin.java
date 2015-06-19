package com.twu.menu;

import com.twu.LoginController;
import com.twu.users.NullUser;
import com.twu.users.User;

// It allows the customer to login and gives the present user.

public class CustomerLogin implements Option {
    private LoginController loginController;
    private MenuView menuView;
    private CustomerMenu customerMenu;
    private NullUser nullUser;

    public CustomerLogin(LoginController loginController, MenuView menuView, CustomerMenu customerMenu, NullUser nullUser) {
        this.loginController = loginController;
        this.menuView = menuView;
        this.customerMenu = customerMenu;
        this.nullUser = nullUser;
    }

    @Override
    public void perform(User customer) {

    }

    @Override
    public void perform() {
        User user = loginController.login();
        if(nullUser.equals(user)){
            menuView.displayMessage(user.getAppropriateMessageOnLogin());
            return;
        }
        int continueLoop;
        do {
            menuView.displayMessage(user.getAppropriateMessageOnLogin());
            menuView.displayListOfMenu(customerMenu, user);
            continueLoop = menuView.takeUserInputForMainMenu();

            if (customerMenu.isValidInput(continueLoop))
                customerMenu.performAction(continueLoop,user);
            else
                menuView.errorMessage();
        } while (continueLoop < 8);
    }
}
