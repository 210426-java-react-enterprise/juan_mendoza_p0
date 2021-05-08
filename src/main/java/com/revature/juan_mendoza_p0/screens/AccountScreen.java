package com.revature.juan_mendoza_p0.screens;


import com.revature.juan_mendoza_p0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class AccountScreen extends Screen{


    private double checkings;
    private double savings;

    private BufferedReader consoleReader;
    private ScreenRouter router;


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
    try{
        System.out.println("> ");
        try {
            String selection = consoleReader.readLine();
            switch (selection){
                case "1":
                    System.out.println("How much would you like to deposit?");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
