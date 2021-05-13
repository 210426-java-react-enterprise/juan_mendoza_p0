package com.revature.juan_mendoza_p0.screens;

import com.revature.juan_mendoza_p0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class TransactionScreen extends Screen{
    private ScreenRouter screenRouter;
    private BufferedReader consoleReader;

    public TransactionScreen(BufferedReader consoleReader, ScreenRouter screenRouter){
        super("Deposit/Withdraw","/wdScreen");
        this.consoleReader = consoleReader;
        this.screenRouter = screenRouter;
    }


    @Override
    public void render() {
        System.out.println("Checking Account");
        System.out.println("Make a selection from choices below:");
        System.out.println("1) deposit");
        System.out.println("2) withdraw");

        try{
            System.out.print("> ");
            String selectionUser = consoleReader.readLine();

            switch(selectionUser){
                case "1":
                    System.out.println("$ ");
                    try {
                        String amountDeposit = consoleReader.readLine();
                        double dDeposit = Double.parseDouble(amountDeposit);
                        //ask for deposit amount
                        //verify deposit amount
                        //try block and sql update the new balance

                    }catch (Exception e){ // CHANGE EXCEPTION
                        e.printStackTrace();
                    }
                    break;
                case "2":
                    break;
                default:
                    System.err.println("Invalid Selection");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
