package com.twu;

public class QuitAction implements Option {
    @Override
    public void perform() {
        System.exit(1);
    }
}
