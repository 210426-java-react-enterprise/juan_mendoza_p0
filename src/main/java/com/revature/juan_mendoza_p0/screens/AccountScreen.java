package com.revature.juan_mendoza_p0.screens;


import com.revature.juan_mendoza_p0.doas.TransactionDAO;
import com.revature.juan_mendoza_p0.models.Account;
import com.revature.juan_mendoza_p0.models.AppUser;
import com.revature.juan_mendoza_p0.services.AccountService;
import com.revature.juan_mendoza_p0.util.ScreenRouter;
import com.revature.juan_mendoza_p0.util.UserCache;

import java.io.BufferedReader;
import java.io.IOException;

import static com.revature.juan_mendoza_p0.Driver.getAppState;

public class AccountScreen extends Screen{


    private BufferedReader consoleReader;
    private ScreenRouter router;
    private TransactionDAO transactionDao;
    private Account account;
    private AppUser user;
    private UserCache userCache;
    private AccountService accountService;


    public AccountScreen(BufferedReader consoleReader, ScreenRouter router,
                         TransactionDAO transactionDao, Account account, UserCache userCache,
                         AccountService accountService) {

        super("Account Screen", "/account");
        this.consoleReader = consoleReader;
        this.router = router;
        this.transactionDao = transactionDao;
        this.account = account;
        this.user = user;
        this.userCache = userCache;
        this.accountService = accountService;
    }

    @Override
    public void render() {

        System.out.println("Account Options, choose a valid selection:");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("1) Create Account");
        System.out.println("2) Withdraw/Deposit");
        System.out.println("3) View Balance");
        System.out.println("4) Exit Application");

        try {

            System.out.print("> ");
            String userSelection = consoleReader.readLine();

            switch (userSelection){
                case "1":
                    router.navigate("/creationAccount");
                    break;
                case"2":
                    router.navigate("/transaction");
                    break;
                case "3":
                    double userBalance= transactionDao.getCheckingBalance(userCache.getCurrentUserName());
                    System.out.println("------------------");
                    System.out.println("Balance: $ " +  accountService.formatDoubleToCurrency(userBalance));//"Balance: $ "+
                    System.out.println("------------------");
                    router.navigate("/account");
                    break;
                case "4":
                    System.out.println("Now leaving application.Goodbye.");
                    getAppState().setAppRunning(false);
                    break;
                default:
                    System.err.println("Invalid Selection!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
