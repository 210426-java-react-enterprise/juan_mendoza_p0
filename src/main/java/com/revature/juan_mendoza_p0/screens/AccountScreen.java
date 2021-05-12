package com.revature.juan_mendoza_p0.screens;


import com.revature.juan_mendoza_p0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class AccountScreen extends Screen{


    private BufferedReader consoleReader;
    private ScreenRouter router;

    public AccountScreen(BufferedReader consoleReader,ScreenRouter router) {

        super("Account Screen", "/account");
        this.consoleReader = consoleReader;
        this.router = router;

    }

    @Override
    public void render() {

        System.out.println("Account Options, choose a valid selection:");
        System.out.println("1) Create Savings Account");
        System.out.println("2) Create Checking Account");
        System.out.println("3) Withdraw/Deposit");

        try {

            String userSelection = consoleReader.readLine();
            switch (userSelection){
                case "1":
                    router.navigate("/savings");
                    break;
                case "2":
                    router.navigate("/checkings");
                    break;
                case "3":
                    router.navigate("/wdScreen");
                    break;
                default:
                    System.err.println("Invalid Selection!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
