package com.revature.juan_mendoza_p0.screens;


import com.revature.juan_mendoza_p0.doas.TransactionDAO;
import com.revature.juan_mendoza_p0.models.Account;
import com.revature.juan_mendoza_p0.models.AppUser;
import com.revature.juan_mendoza_p0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class AccountScreen extends Screen{


    private BufferedReader consoleReader;
    private ScreenRouter router;
    private TransactionDAO transactionDao;
    private Account account;
    private AppUser user;


    public AccountScreen(BufferedReader consoleReader, ScreenRouter router,
                         TransactionDAO transactionDao, Account account, AppUser user) {

        super("Account Screen", "/account");
        this.consoleReader = consoleReader;
        this.router = router;
        this.transactionDao = transactionDao;
        this.account = account;
        this.user = user;
    }

    @Override
    public void render() {

        System.out.println("Account Options, choose a valid selection:");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("1) Create Account");
        System.out.println("2) Withdraw/Deposit");

        try {

            System.out.print("> ");
            String userSelection = consoleReader.readLine();

            switch (userSelection){
                case "1":
                    System.out.println("Which type of account would you like to create?");
                    System.out.println("1) checkings account");
                    //System.out.println("2) savings account");
                    try{
                        System.out.print("> ");
                        String selection = consoleReader.readLine();

                        switch (selection){
                            case "1":
                                transactionDao.createAccount(user,"checking", account);
                            default:
                                System.err.println("Invalid Selection");
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    //transactionDao.createAccount();
                    //router.navigate("/savings");
                    break;

                case "2":
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
