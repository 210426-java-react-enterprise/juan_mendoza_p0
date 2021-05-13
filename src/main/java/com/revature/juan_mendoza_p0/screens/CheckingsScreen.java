package com.revature.juan_mendoza_p0.screens;

import com.revature.juan_mendoza_p0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

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
        System.out.println("Now in your Checkings Account, please choose an option:");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("1) Withdraw");
        System.out.println("2) Deposit");
        System.out.println("3) View Balance");

        double amount = 0;


        try{
            String userSelection = consoleReader.readLine();
            System.out.print("> ");

            switch (userSelection){
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                default:
                    System.err.println("Invalid Selection!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
