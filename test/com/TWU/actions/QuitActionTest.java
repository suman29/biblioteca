package com.twu.actions;

import com.twu.users.Customer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class QuitActionTest {
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldExitsWithStatusCode1() {
        exit.expectSystemExitWithStatus(1);
        QuitAction quit = new QuitAction();

        quit.perform(new Customer("", ""));
    }
}
