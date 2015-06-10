package com.TWU;

public class QuitOption implements Option {
    @Override
    public void perform() {
        System.exit(1);
    }
}
