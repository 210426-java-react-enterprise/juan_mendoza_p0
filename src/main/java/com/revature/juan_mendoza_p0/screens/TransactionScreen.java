package com.revature.juan_mendoza_p0.screens;

import com.revature.juan_mendoza_p0.doas.TransactionDAO;
import com.revature.juan_mendoza_p0.util.ScreenRouter;
import com.revature.juan_mendoza_p0.util.UserCache;

import java.io.BufferedReader;
import java.io.IOException;

public class TransactionScreen extends Screen{
    private ScreenRouter screenRouter;
    private BufferedReader consoleReader;
    private UserCache userCache;
    private TransactionDAO transactionDao;

    public TransactionScreen(BufferedReader consoleReader, ScreenRouter screenRouter,
                             TransactionDAO transactionDao, UserCache userCache){
        super("Deposit/Withdraw","/transaction");
        this.consoleReader = consoleReader;
        this.screenRouter = screenRouter;
        this.userCache = userCache;
        this.transactionDao = transactionDao;
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
                    System.out.print("$ ");
                    try {
                        String amountDeposit = consoleReader.readLine();//ask for deposit amount
                        double dDeposit = Double.parseDouble(amountDeposit);
                        transactionDao.depositBalance(dDeposit,userCache.getCurrentUserName());
                        //verify deposit amount
                            //we need accountService
                        //try block and sql update the new balance

                    }catch (Exception e){ // CHANGE EXCEPTION
                        e.printStackTrace();
                    }
                    screenRouter.navigate("/account");
                    break;
                case "2":
                    System.out.print("$ ");
                    try {
                        String withdrawAmount = consoleReader.readLine();//ask for withdraw amount
                        double dDeposit = Double.parseDouble(withdrawAmount);
                        //verify deposit amount
                        //we need accountService
                        //try block and sql update the new balance

                    }catch (Exception e){ // CHANGE EXCEPTION
                        e.printStackTrace();
                    }

                    break;
                default:
                    System.err.println("Invalid Selection");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
