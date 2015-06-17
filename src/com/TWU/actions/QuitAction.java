package com.twu.actions;

import com.twu.Option;

public class QuitAction implements Option {
    @Override
    public void perform() {
        System.exit(1);
    }
}
