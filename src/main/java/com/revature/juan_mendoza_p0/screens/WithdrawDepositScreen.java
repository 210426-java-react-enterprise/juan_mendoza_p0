package com.revature.juan_mendoza_p0.screens;

import com.revature.juan_mendoza_p0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class WithdrawDepositScreen extends Screen{
    private ScreenRouter screenRouter;
    private BufferedReader consoleReader;

    public WithdrawDepositScreen(BufferedReader consoleReader, ScreenRouter screenRouter){
        super("Deposit/Withdraw","/wdScreen");
        this.consoleReader = consoleReader;
        this.screenRouter = screenRouter;
    }


    @Override
    public void render() {
        System.out.println("");
        System.out.println("Choose which type of account you like to access:");
        System.out.println("1)checking");
        System.out.println("2)savings");

        try{
            System.out.print("> ");
            String selectionUser = consoleReader.readLine();

            switch(selectionUser){
                case "1":
                    screenRouter.navigate("/checking");
                    break;
                case "2":
                    screenRouter.navigate("/savings");
                    break;
                default:
                    System.err.println("Invalid Selection");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
