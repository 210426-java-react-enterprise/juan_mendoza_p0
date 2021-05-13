package com.revature.juan_mendoza_p0.util;


import com.revature.juan_mendoza_p0.doas.TransactionDAO;
import com.revature.juan_mendoza_p0.doas.UserDAO;
import com.revature.juan_mendoza_p0.models.Account;
import com.revature.juan_mendoza_p0.models.AppUser;
import com.revature.juan_mendoza_p0.screens.*;
import com.revature.juan_mendoza_p0.services.AccountService;
import com.revature.juan_mendoza_p0.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    private BufferedReader consoleReader;
    private ScreenRouter router;
    private boolean appRunning;
    private Account account;
    private TransactionDAO transactionDao;
    private AppUser user;
    private UserCache userCache;
    private UserService userService;
    private AccountService accountService;

    public AppState(){
        System.out.println("Initializing application ...");
        this.appRunning = true;

        //where we create instance
        this.consoleReader = new BufferedReader(new InputStreamReader(System.in));
        final UserDAO userDOA = new UserDAO();
        transactionDao = new TransactionDAO();
        router = new ScreenRouter();
        this.account = new Account();
        this.userCache = new UserCache();
        this.userService = new UserService(userDOA);
        this.accountService = new AccountService();


        //chain addScreen method, cause we return instance of ScreenRouter in method
        router.addScreen(new WelcomeScreen(consoleReader,router))
                .addScreen(new LoginScreen(consoleReader,router, userService,userCache))
                .addScreen(new RegisterScreen(consoleReader, router,userService))
                .addScreen(new TransactionScreen(consoleReader,router,transactionDao,userCache))
                .addScreen(new CreationAccountScreen(consoleReader,router, transactionDao, userCache,account))
                .addScreen(new AccountScreen(consoleReader,router,transactionDao, account,userCache,accountService));

        System.out.println("System is initialized!");
    }

    public ScreenRouter getRouter() {
        return router;
    }

    public boolean isAppRunning() {
        return appRunning;
    }

    public void setAppRunning(boolean appRunning) {
        this.appRunning = appRunning;
    }
}
