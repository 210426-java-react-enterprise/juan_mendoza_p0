package com.revature.juan_mendoza_p0.util;


import com.revature.juan_mendoza_p0.doas.UserDOA;
import com.revature.juan_mendoza_p0.screens.LoginScreen;
import com.revature.juan_mendoza_p0.screens.RegisterScreen;
import com.revature.juan_mendoza_p0.screens.WelcomeScreen;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    private BufferedReader consoleReader;
    private ScreenRouter router;
    private boolean appRunning;

    public AppState(){
        System.out.println("Initializing application ...");
        this.appRunning = true;

        //where we create instance
        this.consoleReader = new BufferedReader(new InputStreamReader(System.in));

        final UserDOA userDOA = new UserDOA();

        router = new ScreenRouter();

        router.addScreen(new WelcomeScreen(consoleReader,router))
                .addScreen(new LoginScreen(consoleReader,router))
                .addScreen(new RegisterScreen(consoleReader, router));

        System.out.println("System is initialized!");
    }

    public BufferedReader getConsoleReader() {
        return consoleReader;
    }

    public ScreenRouter getRouter() {
        return router;
    }

    public boolean isAppRunning() {
        return appRunning;
    }

    public void setAppRunning(boolean appRunning) {
        this.appRunning = appRunning;
    }
}
