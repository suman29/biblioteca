package com.TWU;

public class QuitOption implements Options {
    @Override
    public void perform() {
        System.exit(1);
    }
}
