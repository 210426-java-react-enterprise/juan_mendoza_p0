package com.revature.juan_mendoza_p0.screens;

import com.revature.juan_mendoza_p0.util.ScreenRouter;

import java.io.BufferedReader;

public class CheckingsScreen extends Screen {
    private ScreenRouter router;
    private BufferedReader consoleReader;

    public CheckingsScreen(BufferedReader consoleReader, ScreenRouter router){
        super("Checkings Screen", "/checkings");
        this.consoleReader= consoleReader;
        this.router = router;
    }
    @Override
    public void render() {

    }
}
