package com.revature.juan_mendoza_p0.screens;

import com.revature.juan_mendoza_p0.util.ScreenRouter;

import java.io.BufferedReader;

public class SavingScreen extends Screen{
    private ScreenRouter router;
    private BufferedReader consoleReader;

    public SavingScreen(BufferedReader consoleReader, ScreenRouter router){
        super("Saving Screen", "/savings");
        this.consoleReader= consoleReader;
        this.router = router;
    }
    @Override
    public void render() {

    }
}
