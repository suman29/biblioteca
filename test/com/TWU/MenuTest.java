package com.TWU;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuTest {

    @Test
    public void checkIfMenuIsRepresentedProperly() {
        Menu menuList = new Menu();

        String actualOutput = menuList.toString();
        String expectedOutput = "1. List Of Books" + System.lineSeparator() + "Enter your choice:";

        assertEquals(expectedOutput, actualOutput);
    }
}
