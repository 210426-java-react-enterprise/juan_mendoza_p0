package com.revature.juan_mendoza_p0.screens;

import com.revature.juan_mendoza_p0.doas.TransactionDAO;
import com.revature.juan_mendoza_p0.models.Account;
import com.revature.juan_mendoza_p0.util.ScreenRouter;
import com.revature.juan_mendoza_p0.util.UserCache;

import java.io.BufferedReader;
import java.io.IOException;

public class CreationAccountScreen extends Screen{

    private BufferedReader consoleReader;
    private ScreenRouter router;
    private TransactionDAO transactionDao;
    private UserCache userCache;
    private Account account;


    public CreationAccountScreen(BufferedReader consoleReader, ScreenRouter router,
                                 TransactionDAO transactionDAO, UserCache userCache,Account account){
        super("Account Creation","/creationAccount");
        this.consoleReader = consoleReader;
        this.router = router;
        this.transactionDao = transactionDAO;
        this.userCache = userCache;
        this.account = account;
    }



    @Override
    public void render() {
        System.out.println("What account do you wish to create?");
        System.out.println("++++++++++++++++++++++++++++++++++++++");
        System.out.println("1) checking account");

        try{
            System.out.print("> ");
            String userSelection = consoleReader.readLine();

            switch (userSelection){
                case "1":
                    transactionDao.createAccount(userCache.getCurrentUserName(),"checking", account);
                    transactionDao.creatCheckingAccount(userCache.getCurrentUserName());
                    router.navigate("/account");
                    break;
                default:
                    System.err.println("Invalid Selection!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
