package com.revature.juan_mendoza_p0.util;


import com.revature.juan_mendoza_p0.doas.UserDAO;
import com.revature.juan_mendoza_p0.screens.*;

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

        final UserDAO userDOA = new UserDAO();

        router = new ScreenRouter();

        //chain addScreen method, cause we return instance of ScreenRouter in method
        router.addScreen(new WelcomeScreen(consoleReader,router))
                .addScreen(new LoginScreen(consoleReader,router))
                .addScreen(new RegisterScreen(consoleReader, router))
                .addScreen(new WithdrawDepositScreen(consoleReader,router))
                .addScreen(new AccountScreen(consoleReader,router))
                .addScreen(new SavingScreen(consoleReader,router))
                .addScreen(new CheckingsScreen(consoleReader,router));

        System.out.println("System is initialized!");
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
