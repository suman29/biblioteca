package com.TWU;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class QuitOptionTest {
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldExitsWithStatusCode1() {
        exit.expectSystemExitWithStatus(1);
        QuitOption quit = new QuitOption();

        quit.perform();
    }
}
