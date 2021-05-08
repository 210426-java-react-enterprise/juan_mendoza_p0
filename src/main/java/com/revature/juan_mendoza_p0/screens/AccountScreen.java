package com.revature.juan_mendoza_p0.screens;


import com.revature.juan_mendoza_p0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class AccountScreen extends Screen{


    private BufferedReader consoleReader;
    private ScreenRouter router;

    private double checkingAmount;
    private double savingAmount;

    public AccountScreen(BufferedReader consoleReader,ScreenRouter router) {

        super("Account Screen", "/account");
        this.consoleReader = consoleReader;
        this.router = router;

    }

    @Override
    public void render() {

        System.out.println("Account Screen, choose an option.");
        System.out.println("1) Deposit");
        System.out.println("2) Withdraw");
    }


}
