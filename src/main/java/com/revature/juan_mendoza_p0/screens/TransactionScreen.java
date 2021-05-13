package com.revature.juan_mendoza_p0.screens;

import com.revature.juan_mendoza_p0.doas.TransactionDAO;
import com.revature.juan_mendoza_p0.exceptions.InvalidInputException;
import com.revature.juan_mendoza_p0.exceptions.InvalidRequestException;
import com.revature.juan_mendoza_p0.exceptions.OverDraftInputException;
import com.revature.juan_mendoza_p0.services.AccountService;
import com.revature.juan_mendoza_p0.util.ScreenRouter;
import com.revature.juan_mendoza_p0.util.UserCache;

import java.io.BufferedReader;
import java.io.IOException;

public class TransactionScreen extends Screen{
    private ScreenRouter screenRouter;
    private BufferedReader consoleReader;
    private UserCache userCache;
    private TransactionDAO transactionDao;
    private AccountService accountService;

    public TransactionScreen(BufferedReader consoleReader, ScreenRouter screenRouter,
                             TransactionDAO transactionDao, UserCache userCache,
                             AccountService accountService){
        super("Deposit/Withdraw","/transaction");
        this.consoleReader = consoleReader;
        this.screenRouter = screenRouter;
        this.userCache = userCache;
        this.transactionDao = transactionDao;
        this.accountService = accountService;
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
                        boolean verifyDeposit = accountService.verifyInputGreaterZero(dDeposit);
                        //verify deposit amount
                        if (verifyDeposit) {
                            transactionDao.depositBalance(dDeposit, userCache.getCurrentUserName());

                        }
                    }catch(NumberFormatException e){
                        System.err.println("That is not a number!");
                    }catch(InvalidInputException e){
                        System.err.println("Deposited amount is below zero!");
                    }
                    screenRouter.navigate("/account");
                    break;
                case "2":
                    System.out.print("$ ");
                    try {
                        String withdrawAmount = consoleReader.readLine();//ask for withdraw amount
                        double dWithdrawn = Double.parseDouble(withdrawAmount);
                        boolean verifityWithdraw = accountService.isoverDraftingOccuring(userCache.getCurrentUserName(),
                                                                                    dWithdrawn);
                        boolean negVerify = accountService.verifyInputGreaterZero(dWithdrawn);

                        if(verifityWithdraw && negVerify){
                            transactionDao.withdrawFromBalance(userCache.getCurrentUserName(), dWithdrawn);
                        }
                    }catch (NumberFormatException e) {
                        System.err.println("That is not a number!");
                    }catch(InvalidInputException e){
                            System.err.println("Deposited amount is below zero!");
                    }catch(OverDraftInputException e){
                        System.err.println("Overdrafting is not permitted!");
                    }
                    screenRouter.navigate("/account");
                    break;
                default:
                    System.err.println("Invalid Selection");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
